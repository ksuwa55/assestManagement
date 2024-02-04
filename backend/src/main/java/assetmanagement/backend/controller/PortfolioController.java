package assetmanagement.backend.controller;

import assetmanagement.backend.model.Portfolio;
import assetmanagement.backend.model.Stock;
import assetmanagement.backend.repository.PortfolioRepository;
import assetmanagement.backend.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class PortfolioController {
    private final PortfolioRepository portfolioRepository;

    private final PortfolioService portfolioService;


    public PortfolioController(PortfolioRepository portfolioRepository, PortfolioService portfolioService) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioService = portfolioService;
    }

    @PostMapping("/send-to-portfolio")
    public void sendStockToPortfolio(@RequestParam String stock_symbol, @RequestParam Long userId) {
        Portfolio portfolio = new Portfolio();
        portfolio.setStock_symbol(stock_symbol);
        portfolio.setUserId(userId);

        portfolioRepository.save(portfolio);
    }

    @GetMapping("/portfolio/{userId}")
    public List<Stock> showStocksByPortfolio(@PathVariable Long userId) {
        System.out.println("Received request for user ID: " + userId);
        List<Stock> filteredStocks = portfolioService.scrapeStockInfoListByUserId(userId);
        return filteredStocks;
    }

    @PostMapping("/delete")
    public void deleteStockFromPortfolio(@RequestParam Long id) {
        portfolioRepository.deleteById(id);
    }
}
