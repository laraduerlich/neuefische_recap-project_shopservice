package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo {
    List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void printOrder(Order order) {
        System.out.println(order);
    }

    public void printAllOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
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
