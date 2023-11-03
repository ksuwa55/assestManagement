package assetmanagement.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StockServiceTest {

    @Test
    void testGetDowSymbolsFromFile () {
        List<String> expectedSymbols = Arrays.asList("AAPL",	"GOOGL",	"MSFT",	"AMZN",	"NVDA",	"TSLA",	"META",	"LLY",	"TSM",	"UNH",	"BRK-B",	"FB",	"JNJ",	"JPM",	"XOM",	"WMT",	"NVO",	"V",	"MA",	"PG",	"AVGO",	"HD",	"ORCL",	"CVX",	"BRK-A",	"MRK",	"ABBV",	"KO",	"ASML",	"PEP",	"RDS.A",	"COST",	"BAC",	"ADBE",	"BABA",	"TM",	"AZN",	"CSCO",	"NVS",	"BRK.A",	"TMO",	"MCD",	"CRM",	"SHEL",	"PFE",	"FMX",	"ACN",	"CMCSA",	"DHR");

        // create stockService Instance
        StockService stockService = new StockService();

        // Call getDowSymbolsFromFile method,  the paramater of this method is defined both StockServie.java and this file
        List<String> symbols = stockService.getDowSymbolsFromFile();

        // Make sure not null symbols and size of the file
        assertNotNull(symbols);
        assertEquals(expectedSymbols.size(), symbols.size());

        // Make sure values of result and expected
        for(int i = 0; i < symbols.size(); i ++){
            assertEquals(expectedSymbols.get(i), symbols.get(i));
        }
    }
}
