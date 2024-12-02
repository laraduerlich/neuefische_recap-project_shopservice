package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepo {
    static List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public static boolean containsProduct(Product product) {
        return products.contains(product);
    }

    public void printAllProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void printProduct(Product product) {
        System.out.println(product);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
}
