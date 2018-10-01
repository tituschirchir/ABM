package client;

import injectors.Companies;
import models.faces.Ecosystem;
import models.impls.FinancialEcosystem;
import models.impls.Trader;
import models.products.OrderType;

import java.util.stream.IntStream;

public class Client {
    private static final String RES_DIR = "src/main/resources/";

    public static void main(String[] args) {
        Loader.loadDb(RES_DIR + "stocks.csv", RES_DIR + "companies.csv");
        Trader joe = new Trader("Joe", 10000);
        Ecosystem ecosystem = new FinancialEcosystem();
        Companies.getCompanies().values().forEach(ecosystem::addAgents);
        ecosystem.addAgents(joe);
        joe.placeOrder("TNXP", OrderType.LIMIT_BUY, 1.00, 100);
        joe.placeOrder("GS", OrderType.LIMIT_BUY, 220, 10);
        joe.placeOrder("BAC", OrderType.LIMIT_BUY, 25, 10);
        joe.placeOrder("MS", OrderType.LIMIT_BUY, 40, 10);

        IntStream.range(0, 1000).forEach(x -> {
            System.out.println(joe.value());
            ecosystem.call();
        });

        System.out.println("Test");
    }
}
