package models.faces;

import units.Price;

import java.util.Map;
import java.util.Stack;

public interface Exchange {
    Map<String, Stack<Price>> priceList();

    default Stack<Price> getPriceForTicker(String ticker) {
        return priceList().get(ticker);
    }

    void pushTickerPrice(String ticker, double value, double dt);
}
