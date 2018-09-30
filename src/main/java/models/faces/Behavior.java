package models.faces;

import models.products.Stock;
import units.PriceHistory;

import java.util.Random;
import java.util.function.BiConsumer;

public interface Behavior extends Actionable {
    BiConsumer<String, Exchange<Stock>> stockEvolver = (ticker, exchange) -> {
        Stock stock = exchange.getComponent(ticker);
        if (stock != null) {
            double mean = stock.getTsReturns().stream().mapToDouble(x -> x)
                    .summaryStatistics().getAverage();
            PriceHistory price = stock.getTimeSeries();
            double vol = 0.25;
            double value = price.getCurrent();
            double dt = 1 / 252.;
            value = value * Math.exp((dt) * mean - 0.5 * vol * vol * new Random().nextGaussian());
            exchange.getComponent(ticker).pushPrice(value);
        }
    };
}
