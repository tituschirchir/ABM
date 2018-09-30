import org.junit.Assert;
import org.junit.Test;
import models.products.Stock;
import units.TimeKeeper;

import java.util.List;

public class StockTest {
    @Test
    public void timeseriesReturnsTest() {
        Stock stock = new Stock(12.);
        TimeKeeper.getInstance().evolve();
        stock.pushPrice(12);
        TimeKeeper.getInstance().evolve();
        stock.pushPrice(13);
        TimeKeeper.getInstance().evolve();
        stock.pushPrice(14);
        TimeKeeper.getInstance().evolve();
        stock.pushPrice(15);
        List<Double> tsReturns = stock.getTsReturns();
        Assert.assertEquals(0.0, tsReturns.get(0), 1e-8);
        Assert.assertEquals(0.08333333333333333, tsReturns.get(1), 1e-8);
        Assert.assertEquals(0.07692307692307693, tsReturns.get(2), 1e-8);
        Assert.assertEquals(0.07142857142857142, tsReturns.get(3), 1e-8);
    }
}
