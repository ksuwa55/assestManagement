package assetmanagement.backend.controller;

import assetmanagement.backend.model.Portfolio;
import assetmanagement.backend.repository.PortfolioRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class PortfolioController {
    private final PortfolioRepository portfolioRepository;

    public PortfolioController(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @PostMapping("/send-to-portfolio")
    public void sendStockToPortfolio(@RequestParam String stock_symbol, @RequestParam Long userId) {
        Portfolio portfolio = new Portfolio();
        portfolio.setStock_symbol(stock_symbol);
        portfolio.setUserId(userId);

        portfolioRepository.save(portfolio);
    }
}
