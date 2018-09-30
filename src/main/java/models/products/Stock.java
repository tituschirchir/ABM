package models.products;

import models.faces.Valuable;
import units.PriceHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stock implements Valuable {
    private final String ticker;
    private PriceHistory priceHistory = new PriceHistory();

    public Stock(String ticker, double value) {
        this.ticker = ticker;
        priceHistory.addValue(value);
    }

    public List<Double> getTsReturns() {
        List<Double> vals = new ArrayList<>(priceHistory.values());
        return IntStream.range(1, vals.size())
                .mapToObj(x -> (vals.get(x) - vals.get(x - 1)) / vals.get(x - 1))
                .collect(Collectors.toList());
    }

    public void pushPrice(double value) {
        priceHistory.addValue(value);
    }

    public PriceHistory getTimeSeries() {
        return priceHistory;
    }

    @Override
    public double value() {
        return priceHistory.getCurrent();
    }

    public String getTicker() {
        return ticker;
    }
}
