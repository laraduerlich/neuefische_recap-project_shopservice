package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShopService {
    // Eigenschaft für Konstruktor
    private OrderRepo orderRepo = new OrderMapRepo();
    private ProductRepo productRepo = new ProductRepo();

    // Hinzufügen einer Bestellung mit Check einer Exception
    public Order addOrder(List<String> productIds) throws ProductNotAvailableException {
        List<Product> products = new ArrayList<>();
        for (String productId : productIds) {
            Optional<Product> databaseProductToOrder = productRepo.getProductById(productId);
            Product productToOrder = databaseProductToOrder.orElseThrow(() -> new ProductNotAvailableException(productId));
            products.add(productToOrder);
        }

        Order newOrder = new Order(UUID.randomUUID().toString(), products, OrderStatus.PROCESSING);

        return orderRepo.addOrder(newOrder);
    }

    // Ausgabe aller Bestellungen mit bestimmtem Status
    public List<Order> getAllOrdersByStatus(OrderStatus status) {
        List<Order> orders = new ArrayList<>();
        List<Order> allOrders = orderRepo.getAllOrders();
        allOrders.stream()
                .filter(order -> order.orderStatus() == status)
                .forEach(orders::add);
        return orders;
    }

    // Update für Order mit neuem Status
    public Order updateOrder(String id){
        Order order = orderRepo.getOrderById(id);
        if (order.orderStatus() == OrderStatus.PROCESSING) {
            Order newStatus = order.withOrderStatus(OrderStatus.IN_DELIVERY);
            return orderRepo.addOrder(newStatus);
        } else if (order.orderStatus() == OrderStatus.IN_DELIVERY) {
            Order newStatus = order.withOrderStatus(OrderStatus.COMPLETED);
            return orderRepo.addOrder(newStatus);
        } else {
            Order newStatus = order.withOrderStatus(OrderStatus.COMPLETED);
            return orderRepo.addOrder(newStatus);
        }
    }

}
