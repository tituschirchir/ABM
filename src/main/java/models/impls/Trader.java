package models.impls;

import models.faces.Behavior;
import models.faces.Valuable;
import models.products.Order;
import models.products.OrderType;
import models.products.Position;
import models.products.Stock;

import java.util.ArrayList;
import java.util.List;

public class Trader extends AgentImpl implements Valuable {
    private double worth;
    List<Order> orders = new ArrayList<>();
    List<Position<Valuable>> portfolio = new ArrayList<>();

    public Trader(String name_) {
        this(name_, 100000);
    }

    public Trader(String name_, double worth) {
        super(name_);
        this.worth = worth;
        this.addBehavior((Behavior) this::executeOrders);
    }

    private void executeOrders() {
        orders.forEach(x -> x.executeFor(this));
    }

    public void placeOrder(Stock component, OrderType type, double price, double quantity) {
        orders.add(Order.placeOrder(component, type, price, quantity));
    }

    public List<Position<Valuable>> getStockPortfolio() {
        return portfolio;
    }

    public void addPosition(Position<Valuable> position) {
        portfolio.add(position);
    }

    public void changeWorth(double by) {
        worth += by;
    }

    @Override
    public double value() {
        return this.worth + portfolio.stream().mapToDouble(Position::value).sum();
    }

    public double liquidCash() {
        return worth;
    }
}
