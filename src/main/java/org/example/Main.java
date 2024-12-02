package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Produkte werden initialisiert
        Product product1 = new Product(1, "banane");
        Product product2 = new Product(2, "apple");
        Product product3 = new Product(3, "orange");
        Product product4 = new Product(4, "kiwi");

        // ProductRepo wird initialisiert
        ProductRepo productRepo = new ProductRepo();

        // Produkte werden ProductRepo hinzugefügt
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);
        productRepo.addProduct(product3);

        // OrderRepo wird initialisiert
        OrderRepo orderRepo = new OrderMapRepo();

        // ShopService wird mit ausgewähltem Repo erstellt
        ShopService shopService = new ShopService(orderRepo);

        // Bestellungen werden aufgegeben
        shopService.placeOrder(1, product1);
        shopService.placeOrder(2, product2);
        shopService.placeOrder(3, product4);

    }
}