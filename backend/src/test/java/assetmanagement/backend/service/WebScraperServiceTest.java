package assetmanagement.backend.service;

import assetmanagement.backend.model.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebScraperServiceTest {

    private WebScraperService webScraperService;

    @BeforeEach
    public void setUp() {
        webScraperService = new WebScraperService();
    }

    @Test
    void testScrapeStockInfoList() {
        List<Stock> stockList = webScraperService.scrapeStockInfoList();

        String firstSymbol = stockList.get(0).getSymbol();
        String firstName = stockList.get(0).getName();
        Double firstPrice = stockList.get(0).getPrice();
        Double firstMarketCapita = stockList.get(0).getMarket_capita();
        assertEquals("AAPL", firstSymbol);
        assertEquals("アップル", firstName);
        assertEquals(179.46, firstPrice);
        assertEquals(2805719275.00, firstMarketCapita);


        String secondSymbol = stockList.get(1).getSymbol();
        String secondName = stockList.get(1).getName();
        Double secondPrice = stockList.get(1).getPrice();
        Double secondMarketCapita = stockList.get(1).getMarket_capita();
        assertEquals("MSFT", secondSymbol);
        assertEquals("マイクロソフト", secondName);
        assertEquals(324.04, secondPrice);
        assertEquals(2407540636.00, secondMarketCapita);
    }
}
