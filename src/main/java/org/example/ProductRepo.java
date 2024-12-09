package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductRepo {
    // Erstellung der Produkt Liste
    private List<Product> products;

    public ProductRepo() {
        products = new ArrayList<>();
        products.add(new Product("1", "Apfel"));
    }

    // Hinzufügen eines Produktes
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    // Entfernen eines Produktes
    public void removeProduct(String id) {
        for (Product product : products) {
            if (product.id().equals(id)) {
                products.remove(product);
                return;
            }
        }
    }

    // Abfrage ob ein Produkt in der Liste enthalten ist mit Rückgabe eines Optionals
    public Optional<Product> getProductById(String id) {
        for (Product product : products) {
            if (product.id().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    // Ausgabe alle Produkte
    public List<Product> getAllProducts() {
        return products;
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
