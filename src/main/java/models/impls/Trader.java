package models.impls;

import models.faces.Portfolio;
import models.products.Position;
import models.products.Stock;

public class Trader extends AgentImpl {

    Portfolio<Position<Stock>> portfolio = new Portfolio();
    public Trader(String name_) {
        super(name_);
    }

}
