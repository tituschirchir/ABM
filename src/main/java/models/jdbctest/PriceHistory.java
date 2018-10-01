package models.jdbctest;

import java.sql.Timestamp;

public class PriceHistory {
    private String ticker;
    private Timestamp time;
    private double value;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Timestamp getTime() {
        return time;
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

    @Override
    public String toString() {
        return "PriceHistory{" + "ticker='" + ticker + '\'' +
                ", time=" + time +
                ", value=" + value +
                '}';
    }
}
