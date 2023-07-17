package assetmanagement.backend.service;

import assetmanagement.backend.model.StockInfo;

import java.util.ArrayList;
import java.util.List;

public class StockService {
    public List<StockInfo> searchStocksByCriteria(double per, double pbr, double roe){
        // Make API request to Alpha Vantage and filter stocks based on the provided criteria
        // Replace this with your actual implementation using the Alpha Vantage API
        // You can use the `RestTemplate` to send HTTP requests to Alpha Vantage API

        // Example code to create dummy stock data for demonstration
        List<StockInfo> stocks = new ArrayList<>();
        stocks.add(new StockInfo("AAPL", "Apple Inc.", 30.5, 2.1, 15.2, 20000));
        stocks.add(new StockInfo("GOOGL", "Alphabet Inc.", 25.8, 1.8, 18.7, 30000));
        stocks.add(new StockInfo("MSFT", "Microsoft Corporation", 35.9, 3.2, 20.1, 250000));

        // Filter stocks based on criteria
        List<StockInfo> filteredStocs = new ArrayList<>();
        for (StockInfo stock : stocks){
            if (stock.getPer() <= per && stock.getPbr() <= pbr && stock.getRoe() <= roe){
                filteredStocs.add(stock);
            }
        }
        return filteredStocs;
    }
}
