package assetmanagement.backend.service;

import assetmanagement.backend.model.Stock;
import assetmanagement.backend.response.AlphaVantageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    @Autowired
    private WebScraperService webScraperService;
    private static final String DOW_SYMBOLS_FILE_PATH = "C:\\Users\\ksuwa\\Documents\\Coding\\assetManagement\\backend\\src\\main\\resources\\static\\dow_symbols.txt";

    public List<Stock> searchStocksByCriteria(List<String> stockSymbols, double price, double market_capita){
        List<Stock> filteredStocks = new ArrayList<>();

        for (String symbol : stockSymbols) {

            // Process the API response to get the real-time stock data
            Stock stockInfo = (Stock) webScraperService.scrapeStockInfoList();

            // Filter stocks based on criteria and add to the result list
            if (stockInfo != null && stockInfo.getPrice() <= price && stockInfo.getMarket_capita() <= market_capita) {
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
    private Stock extractStockInfoFromApiResponse(AlphaVantageResponse response) {
        // Extract relevant data from the Alpha Vantage API response and create a single StockInfo object
        Stock stockInfo = new Stock();
        stockInfo.setSymbol(response.getSymbol());
        stockInfo.setName(response.getName());
//        stockInfo.setPer(response.getPriceToEarningRatio());
//        stockInfo.setPbr(response.getPriceToBookRatio());
//        stockInfo.setRoe(response.getReturnOnEquity());
        // Add other fields as needed based on the actual response structure
        return stockInfo;
    }
}
