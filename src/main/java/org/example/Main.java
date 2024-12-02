package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product organge = new Product(1,"Orange");
        Product apple = new Product(2,"Apple");
        Product banana = new Product(3,"Banana");

        ProductRepo productRepo = new ProductRepo();

        productRepo.addProduct(organge);
        productRepo.addProduct(apple);
        productRepo.addProduct(banana);

        productRepo.printAllProducts();
        productRepo.removeProduct(organge);
        productRepo.printAllProducts();

        System.out.println("-".repeat(20));

        Order order1 = new Order(1, apple);
        Order order2 = new Order(2, banana);

        OrderListRepo orderListRepo = new OrderListRepo();
        orderListRepo.addOrder(order1);
        orderListRepo.addOrder(order2);

        System.out.println(orderListRepo.getAllOrders());
        System.out.println(orderListRepo.getSingleOrder(1));




    }
}