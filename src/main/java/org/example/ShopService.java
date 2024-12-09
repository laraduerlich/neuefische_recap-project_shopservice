package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopService {
    // Eigenschaft für Konstruktor
    private OrderRepo orderRepo = new OrderMapRepo();
    private ProductRepo productRepo = new ProductRepo();

    // Hinzufügen einer Bestellung
    public Order addOrder(List<String> productIds) {
        List<Product> products = new ArrayList<>();
        for (String productId : productIds) {
            Product productToOrder = productRepo.getProductById(productId);
            if (productToOrder == null) {
                System.out.println("Product mit der Id: " + productId + " konnte nicht bestellt werden!");
                return null;
            }
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


}
