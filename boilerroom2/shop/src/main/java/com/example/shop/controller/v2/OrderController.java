package com.example.shop.controller.v2;

import com.example.shop.dto.v1.order.OrderCreateDto;
import com.example.shop.dto.v1.order.OrderItemCreateDto;
import com.example.shop.entity.Order;
import com.example.shop.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Long create(@RequestBody OrderCreateDto dto) {

        Order order = service.createOrder(dto.customerId());

        return order.getId();
    }

    @PostMapping("/{orderId}/items")
    public String addItem(
            @PathVariable Long orderId,
            @RequestBody OrderItemCreateDto dto
    ) {

        service.addItem(orderId, dto.productId(), dto.quantity());

        return "Item added";
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) {
        return service.getById(id);
    }
}