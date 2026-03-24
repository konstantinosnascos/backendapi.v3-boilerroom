package com.example.shop;

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
}
