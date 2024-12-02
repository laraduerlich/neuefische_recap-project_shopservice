package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo {
    // Liste wird erstellt
    List<Order> orders = new ArrayList<>();

    // Hinzufügen von Bestellung
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Entfernen von Bestellung
    public void removeOrder(Order order) {
        orders.remove(order);
    }

    // Ausgabe von allen Bestellungen
    public List<Order> getAllOrders() {
        return orders;
    }

    // Ausgabe von einer Bestellung
    public Order getSingleOrder(int orderId) {
        return orders.get(orderId);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }
}
