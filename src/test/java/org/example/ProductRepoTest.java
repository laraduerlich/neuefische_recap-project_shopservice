package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    private ProductRepo productRepo;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        productRepo = new ProductRepo();
        product1 = new Product(1, "apple");
        product2 =  new Product(2, "banana");
    }

    @Test
    void addProduct_expectAdded() {
        // GIVEN
        int expected = 1;
        // WHEN
        productRepo.addProduct(product1);
        // THEN
        Assertions.assertEquals(expected, productRepo.getAllProducts().size());
    }

    @Test
    void removeProduct_expectRemoved() {
        // GIVEN
        int expected = 0;
        // WHEN
        productRepo.addProduct(product1);
        productRepo.removeProduct(product1);
        // THEN
        Assertions.assertEquals(expected, productRepo.getAllProducts().size());
    }

    @Test
    void containsProduct_expectTrue() {
        // GIVEN
        // WHEN
        productRepo.addProduct(product1);
        boolean contains = productRepo.containsProduct(product1);
        // THEN
        Assertions.assertTrue(contains);
    }

    @Test
    void getAllProducts_expectAll() {
        // GIVEN
        List<Product> expectedProducts = List.of(product1,product2);
        // WHEN
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);
        List<Product> actual = productRepo.getAllProducts();
        // THEN
        Assertions.assertEquals(expectedProducts, actual);
    }
}