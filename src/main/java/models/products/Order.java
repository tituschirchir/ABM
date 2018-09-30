package models.products;

import models.faces.Valuable;
import models.impls.Trader;

public class Order<T extends Valuable> {
    private boolean isClosed = false;
    private T component;
    private double quantity;
    private double price;
    private OrderType type;

    public Order(T component, OrderType type, double price, double quantity) {
        this.component = component;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public static <K extends Valuable> Order<K> placeOrder(K component, OrderType type, double price, double quantity) {
        return new Order<>(component, type, price, quantity);
    }

    public void executeFor(Trader trader) {
        if (isClosed) return;
        double current = component.value();
        if (OrderType.MARKET_BUY == type || (OrderType.LIMIT_BUY == type && price >= current)) {
            if (current * quantity > trader.liquidCash()) {
                System.out.println("Can't afford this order.");
                return;
            }
            trader.addPosition(Position.create(component, current, quantity));
            trader.changeWorth(-1 * current * quantity);
            this.isClosed = true;
            System.out.println("Bought @ " + current);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
