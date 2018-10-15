package dataaccess.models;

import dataaccess.helpers.DbObject;

import java.sql.Timestamp;

public class PriceHistory implements DbObject {
    private String ticker;
    private Timestamp time;
    private double value;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTime() {
        return time.toString();
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
