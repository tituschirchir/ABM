package models.faces;

import models.impls.Company;
import models.products.Stock;
import units.PriceHistory;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface Behavior extends Actionable {
    Consumer<Company> stockEvolver = (company) -> {
        Stock stock = company.getStock();
        if (stock != null) {
            double mean = stock.getTsReturns().stream().mapToDouble(x -> x)
                    .summaryStatistics().getAverage();
            PriceHistory price = stock.getTimeSeries();
            double vol = 0.25;
            double value = price.getCurrent();
            double dt = 1 / 252.;
            value = value * Math.exp((dt) * mean - 0.5 * vol * vol * new Random().nextGaussian());
            stock.pushPrice(value);
        }
    };
}
