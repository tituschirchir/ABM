package models.impls;

import models.faces.Exchange;

import java.util.HashMap;
import java.util.Map;

public class StockExchange implements Exchange<Company> {
    private final String name;
    private Map<String, Company> stockMap = new HashMap<>();
    public static final StockExchange NASDAQ = new StockExchange("NASDAQ");
    public static final StockExchange NYSE = new StockExchange("NYSE");

    private StockExchange(String name) {
        this.name = name;
    }

    @Override
    public Map<String, Company> listedComponents() {
        return stockMap;
    }

    @Override
    public void list(Company stock) {
        stockMap.putIfAbsent(stock.getTicker(), stock);
    }

    public String name() {
        return name;
    }

    public static StockExchange get(String name) {
        if ("NASDAQ".equals(name)) return NASDAQ;
        if ("NYSE".equals(name)) return NYSE;
        return null;
    }
}
