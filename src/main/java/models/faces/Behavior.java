package models.faces;

import units.Price;

import java.util.Comparator;
import java.util.Random;
import java.util.Stack;
import java.util.function.BiConsumer;

public interface Behavior extends Actionable {
    BiConsumer<String, Exchange> stockEvolver = (ticker, exchange) -> {
        Stack<Price> prices = exchange.getPriceForTicker(ticker);
        if (prices != null && !prices.empty()) {
            double mean = prices.stream()
                    .sorted(Comparator.comparing(Price::getTime))
                    .mapToDouble(Price::getValue)
                    .summaryStatistics().getAverage();
            Price price = prices.peek();
            double vol = 0.05;
            double value = price.getValue();
            double dt = 1 / 252.;
            value = value * Math.exp((dt) * mean - 0.5 * vol * vol * new Random().nextGaussian());
            exchange.pushTickerPrice(ticker, value, dt);
        }
    };
}
