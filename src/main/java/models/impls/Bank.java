package models.impls;

import models.faces.Behavior;
import models.faces.Exchange;

public class Bank extends AgentImpl {
    private String ticker;

    public Bank(String name_, String ticker, Exchange exchange) {
        super(name_);
        this.ticker = ticker;
        this.addBehavior(() -> Behavior.stockEvolver.accept(ticker, exchange));
    }

}
