package models.products;

import models.faces.Ecosystem;
import models.faces.Exchange;
import models.impls.Bank;
import models.impls.FinancialEcosystem;
import models.impls.NYSE;
import org.junit.Test;

public class PositionTest {

    @Test
    public void value() {
        Ecosystem ecosystem = new FinancialEcosystem();
        Exchange nyse = new NYSE();
        Stock stock = new Stock("BAC", 30.2);
        nyse.list(stock);
        ecosystem.addAgents(new Bank("Bank of America", "BAC", nyse));
        Position<Stock> stockPosition = Position.createPosition(stock, 31.0, 10);
        System.out.println(stock.value() + ": " + stockPosition.value());
        ecosystem.evolve();
        System.out.println(stock.value() + ": " + stockPosition.value());
        ecosystem.evolve();
        System.out.println(stock.value() + ": " + stockPosition.value());
        ecosystem.evolve();
        System.out.println(stock.value() + ": " + stockPosition.value());
        ecosystem.evolve();
        System.out.println(stock.value() + ": " + stockPosition.value());
    }
}