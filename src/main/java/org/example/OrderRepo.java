package org.example;

import java.util.List;

public interface OrderRepo {

    Order addOrder(Order order);
    void removeOrder(String id);
    List<Order> getAllOrders();
    Order getOrderById(String id);
}
