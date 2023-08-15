package assetmanagement.backend.model;

import jakarta.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "name")
    private String name;


    @Column(name = "price")
    private double price;

    @Column(name = "market_capita")
    private double market_capita;

    public Stock() {
    }

    public Stock(String symbol, String name, double price, double market_capita) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.market_capita = market_capita;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getMarket_capita() {
        return market_capita;
    }

    public void setMarket_capita(double market_capita) {
        this.market_capita = market_capita;
    }
}
