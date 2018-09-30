package models.products;

import models.faces.Ecosystem;
import models.impls.Company;
import models.impls.FinancialEcosystem;
import models.impls.StockExchange;
import org.junit.Test;

public class PositionTest {

    @Test
    public void value() {
        Ecosystem ecosystem = new FinancialEcosystem();
        Stock stock = new Stock(30.2);
        Company bac = Company.create("Company of America", "BAC", "NYSE").withStock(stock);
        StockExchange.NYSE.list(bac);
        ecosystem.addAgents(bac);
        Position<Stock> stockPosition = Position.create(stock, 31.0, 10);
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