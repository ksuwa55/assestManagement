package assetmanagement.backend.controller;

import assetmanagement.backend.model.StockInfo;
import assetmanagement.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/stocks/{per}")
    public List<StockInfo> searchStocksByCriteria(
            @RequestParam("per") double per,
            @RequestParam("pbr") double pbr,
            @RequestParam("roe") double roe) {
        return stockService.searchStocksByCriteria(per, pbr, roe);
    }
}






