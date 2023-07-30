package assetmanagement.backend.service;

import assetmanagement.backend.model.StockInfo;
import assetmanagement.backend.response.AlphaVantageResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    private static final String API_KEY = "6L2HLK4GKMQNZ20Z";
    private static final String ALPHA_VANTAGE_URL = "https://www.alphavantage.co/query";
    private static final String DOW_SYMBOLS_FILE_PATH = "backend/src/main/resources/static/dow_symbols.txt";

    public List<StockInfo> searchStocksByCriteria(List<String> stockSymbols, double per, double pbr, double roe){
        List<StockInfo> filteredStocks = new ArrayList<>();

        for (String symbol : stockSymbols) {
            String apiUrl = ALPHA_VANTAGE_URL + "?function=OVERVIEW&symbol=" + symbol + "&apikey=" + API_KEY;

            // Send the API request and get the response as a JSON
            RestTemplate restTemplate = new RestTemplate();
            AlphaVantageResponse alphaVantageResponse = restTemplate.getForObject(apiUrl, AlphaVantageResponse.class);

            // Process the API response to get the real-time stock data
            StockInfo stockInfo = extractStockInfoFromApiResponse(alphaVantageResponse);

            // Filter stocks based on criteria and add to the result list
            if (stockInfo != null && stockInfo.getPer() <= per && stockInfo.getPbr() <= pbr && stockInfo.getRoe() <= roe) {
                filteredStocks.add(stockInfo);
            }

        }
        return filteredStocks;
    }

    public List<String> getDowSymbolsFromFile() {
        List<String> stockSymbols = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DOW_SYMBOLS_FILE_PATH))){
            String line;
            while ((line = br.readLine()) != null){
                stockSymbols.add(line.trim());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return stockSymbols;
    }
    private StockInfo extractStockInfoFromApiResponse(AlphaVantageResponse response) {
        // Extract relevant data from the Alpha Vantage API response and create a single StockInfo object
        StockInfo stockInfo = new StockInfo();
        stockInfo.setSymbol(response.getSymbol());
        stockInfo.setName(response.getName());
        stockInfo.setPer(response.getPriceToEarningRatio());
        stockInfo.setPbr(response.getPriceToBookRatio());
        stockInfo.setRoe(response.getReturnOnEquity());
        // Add other fields as needed based on the actual response structure
        return stockInfo;
    }
}
