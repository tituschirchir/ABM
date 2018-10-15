package dataaccess.models;

import annotations.TableName;
import dataaccess.helpers.DbObject;

@TableName(name="companies")
public class Company implements DbObject {
    private String ticker;
    private String name;
    private Sector sector;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
