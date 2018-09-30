import injectors.Companies;
import models.faces.Agent;
import models.faces.Ecosystem;
import models.faces.Exchange;
import models.impls.*;
import models.products.Stock;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class EcosystemTest {
    @Test
    public void actionTest() {
        Ecosystem finEco = new FinancialEcosystem();
        Exchange<Company> nyse = StockExchange.NYSE;
        Company gs = Company.create("GS", "GS", "NYSE").withStock(new Stock(230.0));
        Company boa = Company.create("BAC", "BAC", "NYSE").withStock(new Stock(30.0));
        nyse.list(gs);
        nyse.list(boa);
        Agent trader = new Trader("Titus");
        finEco.addAgents(boa, gs, trader);

        IntStream.range(0, 14).forEach(x -> finEco.evolve());

        Assert.assertEquals(2, trader.id());
    }
}
