package org.example;

public class ShopService {

    public Order generateOrder(int orderId, Product product) {
        if (ProductRepo.containsProduct(product)) {
            return new Order(orderId, product);
        } else {
            System.out.println("Product not available");
            return null;
        }
    }
}
