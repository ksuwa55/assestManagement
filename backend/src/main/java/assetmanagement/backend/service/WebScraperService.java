package assetmanagement.backend.service;

import assetmanagement.backend.model.Stock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebScraperService {

    public List<Stock> scrapeStockInfoList() {
        List<Stock> stockList = new ArrayList<>();

        try {
            String stockUrl = "https://finance.yahoo.co.jp/stocks/us/ranking/marketCapital";
            Document document = Jsoup.connect(stockUrl).get();
            Elements rows = document.select("table._32axWNHn tbody tr");

            for (Element row : rows) {
                String stockSymbol = row.selectFirst("._2yWfk53P").text();
                String stockName = row.select("._2ZNlR8xb").text();

                double stockPrice = parseDouble(row.select("._3rXWJKZF").get(0).text());
                double stockMarketCapita = parseDouble(row.select("._3rXWJKZF").get(3).text());

                stockList.add(new Stock(stockSymbol, stockName, stockPrice, stockMarketCapita));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stockList;
    }

    private double parseDouble(String value) {
        try {
            return Double.parseDouble(value.replace(",", "").replace("M", ""));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
