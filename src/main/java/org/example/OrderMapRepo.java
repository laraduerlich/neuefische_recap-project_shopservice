package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Implementierung von Interface OrderRepo
public class OrderMapRepo implements OrderRepo {

    // Erstellung von Map
    private Map<Integer, Order> orders = new HashMap<>();

    // Methoden des Interfaces werden überschrieben
    @Override
    public void addOrder(Order order) {
        orders.put(order.orderId(), order);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order.orderId());
    }

    @Override
    public List<Order> getAllOrders() {
       return new ArrayList<>(orders.values());
    }

    @Override
    public Order getSingleOrder(int orderId) {
        return orders.get(orderId);
    }
}
