package com.example.shop;

import com.example.shop.dto.v1.order.OrderResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderIntegrationTest
{
    @Autowired
    org.springframework.boot.test.web.client.TestRestTemplate restTemplate;

    @Test
    void CreateOrderWithInvalidCustomer()
    {
        Map<String,Long> map = Map.of("customerId",999L);

        ResponseEntity<String> response = restTemplate.postForEntity("/api/v2/orders", map, String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    // TEST 2
    @Test
    void getOrderNotFound() {

        ResponseEntity<String> response =
                restTemplate.getForEntity(
                        "/api/v2/orders/999",
                        String.class
                );

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    //test4
    @Test
    void getOrder() {

        ResponseEntity<OrderResponseDto> response =
                restTemplate.getForEntity(
                        "/api/v2/orders/1",
                        OrderResponseDto.class
                );

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    //test 6

    @Test
    void addItemInvalidProduct() {

        Map<String, Long> request = Map.of(
                "productId", 999L,
                "quantity", 1L
        );

        ResponseEntity<String> response =
                restTemplate.postForEntity(
                        "/api/v2/orders/1/items",
                        request,
                        String.class
                );

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }



}
