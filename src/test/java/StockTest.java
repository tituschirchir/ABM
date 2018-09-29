import org.junit.Assert;
import org.junit.Test;
import units.Price;
import units.Stock;

import java.time.LocalDateTime;
import java.util.List;

public class StockTest {
    @Test
    public void timeseriesReturnsTest() {
        Price p1 = Price.create(12, LocalDateTime.now());
        Price p2 = Price.create(13, LocalDateTime.now());
        Price p3 = Price.create(14, LocalDateTime.now());
        Price p4 = Price.create(15, LocalDateTime.now());

        Stock stock = new Stock();
        stock.pushPrice(p4,p3,p2, p1);
        List<Double> tsReturns = stock.getTsReturns();
        Assert.assertEquals(0.08333333333333333, tsReturns.get(0), 1e-8);
        Assert.assertEquals(0.07692307692307693, tsReturns.get(1), 1e-8);
        Assert.assertEquals(0.07142857142857142, tsReturns.get(2), 1e-8);
    }
}
