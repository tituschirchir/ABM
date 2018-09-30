package models.impls;

import models.faces.Exchange;
import models.products.Futures;

import java.util.Map;

public class CBOE implements Exchange<Futures> {
    @Override
    public String name() {
        return "CBOE";
    }

    @Override
    public Map<String, Futures> listedComponents() {
        return null;
    }

    @Override
    public void list(Futures futures) {

    }
}
