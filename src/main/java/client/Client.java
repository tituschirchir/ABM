package client;

import injectors.Companies;
import models.faces.Ecosystem;
import models.impls.FinancialEcosystem;
import models.impls.Trader;
import models.products.OrderType;
import models.products.Stock;

import java.util.stream.IntStream;

public class Client {
    private static final String RES_DIR = "src/main/resources/";

    public static void main(String[] args) {
        Loader.loadDb(RES_DIR + "stocks.csv", RES_DIR + "companies.csv");
        Trader joe = new Trader("Joe", 10000);
        Ecosystem ecosystem = new FinancialEcosystem();
        Companies.getCompanies().values().forEach(ecosystem::addAgents);
        ecosystem.addAgents(joe);
        Stock tnxp = Companies.get("TNXP").getStock();
        joe.placeOrder(tnxp, OrderType.LIMIT_BUY, 1.00, 100);
        joe.placeOrder(Companies.get("GS").getStock(), OrderType.LIMIT_BUY, 220, 10);
        joe.placeOrder(Companies.get("BAC").getStock(), OrderType.LIMIT_BUY, 25, 10);
        joe.placeOrder(Companies.get("MS").getStock(), OrderType.LIMIT_BUY, 40, 10);

        IntStream.range(0, 100000).forEach(x -> {
            System.out.println(joe.value());
            ecosystem.call();
        });

        System.out.println("Test");
    }
}
