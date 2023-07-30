package assetmanagement.backend.response;

public class AlphaVantageResponse {
    private String symbol;
    private String name;
    private double open;
    private double priceToEarningRatio;
    private double priceToBookRatio;
    private double returnOnEquity;
    private long volume;

    public AlphaVantageResponse() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getPriceToBookRatio() {
        return priceToBookRatio;
    }

    public void setPriceToBookRatio(double priceToBookRatio) {
        this.priceToBookRatio = priceToBookRatio;
    }

    public double getReturnOnEquity() {
        return returnOnEquity;
    }

    public void setReturnOnEquity(double returnOnEquity) {
        this.returnOnEquity = returnOnEquity;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getPriceToEarningRatio() {
        return priceToEarningRatio;
    }

    public void setPriceToEarningRatio(double priceToEarningRatio) {
        this.priceToEarningRatio = priceToEarningRatio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
