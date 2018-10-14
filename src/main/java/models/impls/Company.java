package models.impls;

import models.faces.Behavior;
import models.faces.Exchange;
import models.products.Stock;

public class Company extends AgentImpl {
    private String ticker;
    private final String exchange;
    private Stock stock;

    private Company(String name_, String ticker, String exchange) {
        super(name_);
        this.ticker = ticker;
        this.exchange = exchange;
        this.addBehavior(() -> Behavior.stockEvolver.accept(this));
    }

    public static Company create(String name_, String ticker, String exchange) {
        return new Company(name_, ticker, exchange);
    }

    public String getTicker() {
        return ticker;
    }

    public Company withStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public Stock getStock() {
        return stock;
    }

    public Exchange<Company> getExchange() {
        return StockExchange.get(exchange);
    }
}
