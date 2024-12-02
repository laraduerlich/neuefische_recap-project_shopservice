package org.example;

public class ShopService {
    // Eigenschaft für Konstruktor
    private OrderRepo orderRepo;

    // Konstruktor, der Interface OrderRepo akzeptiert
    public ShopService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    // Hinzufügen einer Bestellung
    public Order placeOrder(int orderId, Product product) {
        if (ProductRepo.containsProduct(product)) {
            return new Order(orderId, product);
        } else {
            System.out.println("Product not available");
            return null;
        }
    }
}
