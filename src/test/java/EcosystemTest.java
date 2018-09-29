import models.faces.Agent;
import models.faces.Ecosystem;
import models.faces.Exchange;
import models.impls.Bank;
import models.impls.FinancialEcosystem;
import models.impls.NYSE;
import models.impls.Trader;
import org.junit.Assert;
import org.junit.Test;

public class EcosystemTest {
    @Test
    public void actionTest() {
        Ecosystem finEco = new FinancialEcosystem();
        Exchange nyse = new NYSE();
        nyse.pushTickerPrice("GS", 223.0, 1 / 252.0);
        Agent bank = new Bank("Goldman Sachs", "GS", nyse);
        Agent trader = new Trader("Titus");
        finEco.addAgents(bank, trader);

        finEco.evolve();
        finEco.evolve();
        finEco.evolve();
        finEco.evolve();
        finEco.evolve();

        Assert.assertEquals(1, trader.id());
        Assert.assertNotEquals(223.0, nyse.getPriceForTicker("GS").peek().getValue());

    }
}
