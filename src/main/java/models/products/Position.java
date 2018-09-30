package models.products;

import models.faces.Valuable;
import units.TimeKeeper;

import java.time.LocalDateTime;

public class Position<T extends Valuable> implements Valuable {
    private T component;
    private LocalDateTime entryDate;
    private double cost;
    private double quantity;
    private boolean isOpen = true;

    private Position(T component, LocalDateTime entryDate, double price, double quantity) {
        this.component = component;
        this.entryDate = entryDate;
        this.cost = price * quantity;
        this.quantity = quantity;
    }

    public static <P extends Valuable> Position<P> createPosition(P component, double price, double quantity) {
        return new Position<>(component, TimeKeeper.dateTime(), price, quantity);
    }

    public T getComponent() {
        return component;
    }

    public double value() {
        return component.value() * quantity - cost;
    }
}
