package services.robinhood;

public class RHInstrument {
    private double margin_initial_ratio;
    private String id;
    private String market;
    private double maintenance_ratio;
    private String state;
    private String type;
    private boolean tradeable;
    private String symbol;
    private double day_trade_ratio;
    private String name;
    private String splits;
    private String url;
    private String country;
    private String list_date;

    public double getMargin_initial_ratio() {
        return margin_initial_ratio;
    }

    public void setMargin_initial_ratio(double margin_initial_ratio) {
        this.margin_initial_ratio = margin_initial_ratio;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public double getMaintenance_ratio() {
        return maintenance_ratio;
    }

    public void setMaintenance_ratio(double maintenance_ratio) {
        this.maintenance_ratio = maintenance_ratio;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isTradeable() {
        return tradeable;
    }

    public void setTradeable(boolean tradeable) {
        this.tradeable = tradeable;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getDay_trade_ratio() {
        return day_trade_ratio;
    }

    public void setDay_trade_ratio(double day_trade_ratio) {
        this.day_trade_ratio = day_trade_ratio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSplits() {
        return splits;
    }

    public void setSplits(String splits) {
        this.splits = splits;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getList_date() {
        return list_date;
    }

    public void setList_date(String list_date) {
        this.list_date = list_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
