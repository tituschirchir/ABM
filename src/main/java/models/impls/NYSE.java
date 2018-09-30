package models.impls;

import models.faces.Exchange;
import models.products.Stock;

import java.util.HashMap;
import java.util.Map;

public class NYSE implements Exchange<Stock> {
    private Map<String, Stock> stockMap = new HashMap<>();

    @Override
    public Map<String, Stock> listedComponents() {
        return stockMap;
    }

    @Override
    public void list(Stock stock) {
        stockMap.putIfAbsent(stock.getTicker(), stock);
    }
}
