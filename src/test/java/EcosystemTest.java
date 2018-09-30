import models.faces.Agent;
import models.faces.Ecosystem;
import models.faces.Exchange;
import models.impls.*;
import models.products.Futures;
import org.junit.Assert;
import org.junit.Test;
import models.products.Stock;

import java.util.stream.IntStream;

public class EcosystemTest {
    @Test
    public void actionTest() {
        Ecosystem finEco = new FinancialEcosystem();
        Exchange<Stock> nyse = new NYSE();
        Exchange<Futures> cboe = new CBOE();
        nyse.list(new Stock("BAC", 30.0));
        nyse.list(new Stock("GS", 260.0));
        Agent gs = new Bank("Goldman Sachs", "GS", nyse);
        Agent boa = new Bank("Bank of America", "BAC", nyse);
        Agent trader = new Trader("Titus");
        finEco.addAgents(boa, gs, trader);

        IntStream.range(0, 14).forEach(x -> finEco.evolve());

        Stock gs2 = nyse.getComponent("GS");

        Assert.assertEquals(2, trader.id());
        gs2.getTimeSeries();
    }
}
