package models.faces;

import models.products.Position;

import java.util.ArrayList;
import java.util.List;

public class Portfolio<T extends Valuable> {
    List<Position<T>> items = new ArrayList<>();

    public List<Position<T>> getItems() {
        return items;
    }

    public void closePosition(String ticker, double quantity){

    }

}
