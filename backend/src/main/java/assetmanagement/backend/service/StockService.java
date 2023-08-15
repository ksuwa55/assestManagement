    package assetmanagement.backend.service;

    import assetmanagement.backend.model.Stock;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

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

        public List<Stock> searchStocksByCriteria(List<String> stockSymbols, double price, double market_capita) {
            List<Stock> filteredStocks = new ArrayList<>();

            List<Stock> stockInfoList = webScraperService.scrapeStockInfoList();

            for (Stock stockInfo : stockInfoList) {
                if (stockSymbols.contains(stockInfo.getSymbol()) &&
                        stockInfo.getPrice() <= price && stockInfo.getMarket_capita() <= market_capita) {
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
    }
