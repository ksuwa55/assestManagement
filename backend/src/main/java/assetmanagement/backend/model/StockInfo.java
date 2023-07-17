package assetmanagement.backend.model;

public class StockInfo {
    private String symbol;
    private String name;
    private double per;
    private double pbr;
    private double roe;

    public StockInfo() {
    }

    public StockInfo(String symbol, String name, double per, double pbr, double roe){
        this.symbol = symbol;
        this.name = name;
        this.per = per;
        this.pbr = pbr;
        this.roe = roe;
    }

    // Getters and setters

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

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public double getPbr() {
        return pbr;
    }

    public void setPbr(double pbr) {
        this.pbr = pbr;
    }

    public double getRoe() {
        return roe;
    }

    public void setRoe(double roe) {
        this.roe = roe;
    }
}
