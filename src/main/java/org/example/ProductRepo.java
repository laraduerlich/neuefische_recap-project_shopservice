package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepo {
    // Erstellung der Produkt Liste
    static List<Product> products = new ArrayList<>();

    // Hinzufügen eines Produktes
    public void addProduct(Product product) {
        products.add(product);
    }

    // Entfernen eines Produktes
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Abfrage ob ein Produkt in der Liste enthalten ist
    public static boolean containsProduct(Product product) {
        return products.contains(product);
    }

    // Ausgabe alle Produkte
    public List<Product> getAllProducts() {
        return products;
    }

    // Ausgabe eines Produktes
    public Product getProduct(int id) {
        Product product = products.get(id);
        return product;
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
