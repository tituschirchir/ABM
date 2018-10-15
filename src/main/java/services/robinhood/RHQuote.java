package services.robinhood;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class RHQuote {
    private double ask_price;
    private double ask_size;
    private double bid_price;// "212.000000",
    private double bid_size;// 100,
    private double last_trade_price;// "213.870000",
    private double last_extended_hours_trade_price;// "214.500000",
    private double previous_close;// "212.970000",
    private double adjusted_previous_close;// "212.970000",
    private String previous_close_date;// "2018-10-11",
    private String symbol;// "GS",
    private boolean trading_halted;// false,
    private boolean has_traded;// true,
    private String last_trade_price_source;// "consolidated",
    private String updated_at;// "2018-10-12T23;//58;//14Z",
    private String instrument;// "https;////api.robinhood.com/instruments/801a9500-8a61-4e1c-ae76-0beb4a135fb1/"

    public double getAsk_price() {
        return ask_price;
    }

    public void setAsk_price(double ask_price) {
        this.ask_price = ask_price;
    }

    public double getAsk_size() {
        return ask_size;
    }

    public void setAsk_size(double ask_size) {
        this.ask_size = ask_size;
    }

    public double getBid_price() {
        return bid_price;
    }

    public void setBid_price(double bid_price) {
        this.bid_price = bid_price;
    }

    public double getBid_size() {
        return bid_size;
    }

    public void setBid_size(double bid_size) {
        this.bid_size = bid_size;
    }

    public double getLast_trade_price() {
        return last_trade_price;
    }

    public void setLast_trade_price(double last_trade_price) {
        this.last_trade_price = last_trade_price;
    }

    public double getLast_extended_hours_trade_price() {
        return last_extended_hours_trade_price;
    }

    public void setLast_extended_hours_trade_price(double last_extended_hours_trade_price) {
        this.last_extended_hours_trade_price = last_extended_hours_trade_price;
    }

    public double getPrevious_close() {
        return previous_close;
    }

    public void setPrevious_close(double previous_close) {
        this.previous_close = previous_close;
    }

    public double getAdjusted_previous_close() {
        return adjusted_previous_close;
    }

    public void setAdjusted_previous_close(double adjusted_previous_close) {
        this.adjusted_previous_close = adjusted_previous_close;
    }

    public String getPrevious_close_date() {
        return previous_close_date;
    }

    public void setPrevious_close_date(String previous_close_date) {
        this.previous_close_date = previous_close_date;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isTrading_halted() {
        return trading_halted;
    }

    public void setTrading_halted(boolean trading_halted) {
        this.trading_halted = trading_halted;
    }

    public boolean isHas_traded() {
        return has_traded;
    }

    public void setHas_traded(boolean has_traded) {
        this.has_traded = has_traded;
    }

    public String getLast_trade_price_source() {
        return last_trade_price_source;
    }

    public void setLast_trade_price_source(String last_trade_price_source) {
        this.last_trade_price_source = last_trade_price_source;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
