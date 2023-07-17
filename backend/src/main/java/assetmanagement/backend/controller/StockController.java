package assetmanagement.backend.controller;

import assetmanagement.backend.model.StockInfo;
import assetmanagement.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/stocks")
    public List<StockInfo> searchStocksByCriteria(
            @RequestParam double per,
            @RequestParam double pbr,
            @RequestParam double roe) {
        return stockService.searchStocksByCriteria(per, pbr, roe);
    }
}
