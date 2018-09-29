package models.impls;

import models.faces.Exchange;
import units.Price;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NYSE implements Exchange {
    private static final LocalDateTime start = LocalDateTime.of(2017, 1, 1, 12, 0);
    private Map<String, Stack<Price>> priceMap = new HashMap<>();

    @Override
    public Map<String, Stack<Price>> priceList() {
        return priceMap;
    }

    @Override
    public void pushTickerPrice(String ticker, double value, double dt) {
        Stack<Price> prices = priceMap.get(ticker);
        LocalDateTime date;
        if (prices == null) {
            prices = new Stack<>();
            date = start;
        } else {
            date = prices.peek().getTime();
        }
        prices.push(Price.create(value, date.plus(1, ChronoUnit.DAYS)));
        priceMap.put(ticker, prices);
    }
}
