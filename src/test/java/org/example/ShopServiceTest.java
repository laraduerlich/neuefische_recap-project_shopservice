package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void addOrderTest() throws ProductNotAvailableException {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1");
        Order expected = Order.builder()
                .products(List.of(new Product("1", "Apfel")))
                .build();

        //WHEN
        Order actual = shopService.addOrder(productsIds);

        //THEN
        assertEquals(expected.products(), actual.products());
    }

    @Test
    void addOrderTest_whenInvalidProductId_expectException() {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1", "2");
        // WHEN
        try {
            Order actual = shopService.addOrder(productsIds);
            fail();
        // THEN
        } catch (ProductNotAvailableException e) {
            assertTrue(true);
        }
    }

    @Test
    void addOrderTest_expectTimestamp() throws ProductNotAvailableException {
        // GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1");
        // WHEN
        Order newOrder = shopService.addOrder(productsIds);
        // THEN
        assertNotNull(newOrder.timestamp());
    }

    @Test
    void getAllOrdersByStatusTest() throws ProductNotAvailableException {
        // GIVEN
        ShopService shopService = new ShopService();
        shopService.addOrder(List.of("1"));
        shopService.addOrder(List.of("1"));
        List<Order> expectedOrders = List.of(
                Order.builder().orderStatus(OrderStatus.PROCESSING).build(),
                Order.builder().orderStatus(OrderStatus.PROCESSING).build()
        );
        // WHEN
        List<Order> actual = shopService.getAllOrdersByStatus(OrderStatus.PROCESSING);

        // THEN
        assertEquals(expectedOrders.size(), actual.size());

    }

    @Test
    void updateOrderTest() throws ProductNotAvailableException {
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