package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo implements OrderRepo {
    // Liste wird erstellt
    private List<Order> orders = new ArrayList<>();

    // Hinzufügen von Bestellung
    public Order addOrder(Order newOrder) {
        orders.add(newOrder);
        return newOrder;
    }

    // Entfernen von Bestellung
    public void removeOrder(String id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                orders.remove(order);
                return;
            }
        }
    }

    // Ausgabe von allen Bestellungen
    public List<Order> getAllOrders() {
        return orders;
    }

    // Ausgabe von einer Bestellung
    public Order getOrderById(String id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                return order;
            }
        }
        return null;
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
