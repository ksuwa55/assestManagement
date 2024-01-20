package assetmanagement.backend.service;

import assetmanagement.backend.model.Stock;
import assetmanagement.backend.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Autowired
    WebScraperService webScraperService;

    public List<Stock> scrapeStockInfoListByUserId(Long user_id){
        List<String> stockSymbols = portfolioRepository.findStockSymbolsByUserId(user_id);
        List<Stock> stockInfoList = webScraperService.scrapeStockInfoList();
        List<Stock> stockListInPortfolio = new ArrayList<>();

        for ( Stock stockInfo : stockInfoList){
            if (stockSymbols.contains(stockInfo.getSymbol())){
                stockListInPortfolio.add(stockInfo);
            }
        }

        return stockListInPortfolio;
    }
}
