package dataaccess.models;

public class Quote {
    private double askPrice;
    private double askSize;
    private double bidPrice;
    private double bidSize;
    private double lastTradePrice;
    private double lastExtendedHoursTradePrice;
    private double previousClose;
    private double adjustedPreviousClose;
    private String previousCloseDate;
    private String symbol;
    private boolean tradingHalted;
    private boolean hasTraded;
    private String lastTradePriceSource;
    private String updatedAt;

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public double getAskSize() {
        return askSize;
    }

    public void setAskSize(double askSize) {
        this.askSize = askSize;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public double getBidSize() {
        return bidSize;
    }

    public void setBidSize(double bidSize) {
        this.bidSize = bidSize;
    }

    public double getLastTradePrice() {
        return lastTradePrice;
    }

    public void setLastTradePrice(double lastTradePrice) {
        this.lastTradePrice = lastTradePrice;
    }

    public double getLastExtendedHoursTradePrice() {
        return lastExtendedHoursTradePrice;
    }

    public void setLastExtendedHoursTradePrice(double lastExtendedHoursTradePrice) {
        this.lastExtendedHoursTradePrice = lastExtendedHoursTradePrice;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public double getAdjustedPreviousClose() {
        return adjustedPreviousClose;
    }

    public void setAdjustedPreviousClose(double adjustedPreviousClose) {
        this.adjustedPreviousClose = adjustedPreviousClose;
    }

    public String getPreviousCloseDate() {
        return previousCloseDate;
    }

    public void setPreviousCloseDate(String previousCloseDate) {
        this.previousCloseDate = previousCloseDate;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isTradingHalted() {
        return tradingHalted;
    }

    public void setTradingHalted(boolean tradingHalted) {
        this.tradingHalted = tradingHalted;
    }

    public boolean isHasTraded() {
        return hasTraded;
    }

    public void setHasTraded(boolean hasTraded) {
        this.hasTraded = hasTraded;
    }

    public String getLastTradePriceSource() {
        return lastTradePriceSource;
    }

    public void setLastTradePriceSource(String lastTradePriceSource) {
        this.lastTradePriceSource = lastTradePriceSource;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
