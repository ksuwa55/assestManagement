package assetmanagement.backend.controller;

import assetmanagement.backend.model.Stock;
import assetmanagement.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/stocks")
    public List<Stock> searchStocksByCriteria(
            @RequestParam("price") double price,
            @RequestParam("market_capita") double market_capita
                                            ) {
        List<String> dowSymbols = stockService.getDowSymbolsFromFile();
        return stockService.searchStocksByCriteria(dowSymbols, price, market_capita);
    }
}






