package assetmanagement.backend.controller;

import assetmanagement.backend.model.StockInfo;
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
    public List<StockInfo> searchStocksByCriteria(
            @RequestParam("per") double per,
            @RequestParam("pbr") double pbr,
            @RequestParam("roe") double roe) {
        List<String> dowSymbols = stockService.getDowSymbolsFromFile();
        return stockService.searchStocksByCriteria(dowSymbols, per, pbr, roe);
    }
}






