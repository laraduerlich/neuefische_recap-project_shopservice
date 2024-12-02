package org.example;

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

        System.out.println(productRepo.containsProduct(organge));
    }
}