package services.robinhood;

import java.util.List;

public class RHCompany {
    private double open;
    private double high;
    private double low;
    private double volume;
    private double average_volume_2_weeks;
    private double average_volume;
    private double high_52_weeks;
    private double dividend_yield;
    private double low_52_weeks;
    private double market_cap;
    private double pe_ratio;
    private double shares_outstanding;
    private String description;
    private String instrument;
    private String ceo;
    private String headquarters_city;
    private String headquarters_state;
    private String sector;
    private int num_employees;
    private int year_founded;
    private String rhInstrument;
    private String splits;
    private String quote;

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getAverage_volume_2_weeks() {
        return average_volume_2_weeks;
    }

    public void setAverage_volume_2_weeks(double average_volume_2_weeks) {
        this.average_volume_2_weeks = average_volume_2_weeks;
    }

    public double getAverage_volume() {
        return average_volume;
    }

    public void setAverage_volume(double average_volume) {
        this.average_volume = average_volume;
    }

    public double getHigh_52_weeks() {
        return high_52_weeks;
    }

    public void setHigh_52_weeks(double high_52_weeks) {
        this.high_52_weeks = high_52_weeks;
    }

    public double getDividend_yield() {
        return dividend_yield;
    }

    public void setDividend_yield(double dividend_yield) {
        this.dividend_yield = dividend_yield;
    }

    public double getLow_52_weeks() {
        return low_52_weeks;
    }

    public void setLow_52_weeks(double low_52_weeks) {
        this.low_52_weeks = low_52_weeks;
    }

    public double getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(double market_cap) {
        this.market_cap = market_cap;
    }

    public double getPe_ratio() {
        return pe_ratio;
    }

    public void setPe_ratio(double pe_ratio) {
        this.pe_ratio = pe_ratio;
    }

    public double getShares_outstanding() {
        return shares_outstanding;
    }

    public void setShares_outstanding(double shares_outstanding) {
        this.shares_outstanding = shares_outstanding;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getHeadquarters_city() {
        return headquarters_city;
    }

    public void setHeadquarters_city(String headquarters_city) {
        this.headquarters_city = headquarters_city;
    }

    public String getHeadquarters_state() {
        return headquarters_state;
    }

    public void setHeadquarters_state(String headquarters_state) {
        this.headquarters_state = headquarters_state;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getNum_employees() {
        return num_employees;
    }

    public void setNum_employees(int num_employees) {
        this.num_employees = num_employees;
    }

    public int getYear_founded() {
        return year_founded;
    }

    public void setYear_founded(int year_founded) {
        this.year_founded = year_founded;
    }

    public String getSplits() {
        return splits;
    }

    public void setSplits(String splits) {
        this.splits = splits;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public String getRhInstrument() {
        return rhInstrument;
    }

    public void setRhInstrument(String rhInstrument) {
        this.rhInstrument = rhInstrument;
    }
}
