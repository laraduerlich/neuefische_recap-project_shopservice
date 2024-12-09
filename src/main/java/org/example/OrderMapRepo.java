package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Implementierung von Interface OrderRepo
public class OrderMapRepo implements OrderRepo {

    // Erstellung von Map
    private Map<String, Order> orders = new HashMap<>();

    // Methoden des Interfaces werden überschrieben
    @Override
    public Order addOrder(Order newOrder) {
        orders.put(newOrder.id(), newOrder);
        return newOrder;
    }

    @Override
    public void removeOrder(String id) {
        orders.remove(id);
    }

    @Override
    public List<Order> getAllOrders() {
       return new ArrayList<>(orders.values());
    }

    @Override
    public Order getOrderById(String id) {
        return orders.get(id);
    }
}
