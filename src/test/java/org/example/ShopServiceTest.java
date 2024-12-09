package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void addOrderTest() {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1");
        Order expected = new Order("-1", List.of(new Product("1", "Apfel")), OrderStatus.PROCESSING);

        //WHEN
        Order actual = shopService.addOrder(productsIds);

        //THEN
        assertEquals(expected.products(), actual.products());
        assertNotNull(expected.id());
    }

    @Test
    void addOrderTest_whenInvalidProductId_expectException() {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1", "2");

        //THEN
        assertThrows(ProductNotAvailableException.class, () -> shopService.addOrder(productsIds));
    }

    @Test
    void getAllOrdersByStatusTest() {
        // GIVEN
        ShopService shopService = new ShopService();
        shopService.addOrder(List.of("1"));
        shopService.addOrder(List.of("1"));
        List<Product> products = List.of(new Product("1", "Apfel"));
        List<Order> expectedOrders = List.of(new Order("1", products, OrderStatus.PROCESSING), new Order("2", products, OrderStatus.PROCESSING));

        // WHEN
        List<Order> actual = shopService.getAllOrdersByStatus(OrderStatus.PROCESSING);

        // THEN
        assertEquals(expectedOrders.size(), actual.size());

    }

    @Test
    void updateOrderTest() {
        // GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1");
        Order processing = shopService.addOrder(productsIds);
        Order expected = Order.builder()
                .orderStatus(OrderStatus.IN_DELIVERY)
                .build();

        // WHEN
        Order updated = shopService.updateOrder(processing.id());

        // THEN
        assertEquals(expected.orderStatus(), updated.orderStatus());


    }

}