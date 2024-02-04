package assetmanagement.backend.controller;

import assetmanagement.backend.model.Portfolio;
import assetmanagement.backend.model.Stock;
import assetmanagement.backend.repository.PortfolioRepository;
import assetmanagement.backend.service.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void sendStockToPortfolio(@RequestParam String stockSymbol, @RequestParam Long userId) {
        Portfolio portfolio = new Portfolio();
        portfolio.setStockSymbol(stockSymbol != null ? stockSymbol : "DEFAULT_VALUE");
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
    public ResponseEntity<String> deleteStockFromPortfolio(@RequestParam Long userId, @RequestParam String stockSymbol) {
        try {
            portfolioRepository.deleteByUserIdAndStockSymbol(userId, stockSymbol);
            return ResponseEntity.ok("Stock deleted successfully");
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete stock");
        }
    }

}
