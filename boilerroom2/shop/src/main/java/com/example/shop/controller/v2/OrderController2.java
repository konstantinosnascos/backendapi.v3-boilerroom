package com.example.shop.controller.v2;

import com.example.shop.dto.v2.order.OrderCreateDto;
import com.example.shop.dto.v2.order.OrderItemCreateDto;
import com.example.shop.dto.v2.order.OrderResponseDto;
import com.example.shop.entity.Order;
import com.example.shop.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/orders")
public class OrderController2 {

    private final OrderService service;

    public OrderController2(OrderService service) {
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
    public OrderResponseDto get(@PathVariable Long id)
    {
        Order order = service.getById(id);
        int totalPrice = order.getItems()
                .stream()
                .mapToInt
                        (t ->
                            t.getPriceAtPurchase() * t.getQuantity()
                        )
                .sum();

        return new OrderResponseDto(order.getId(), order.getCustomer().getId(), totalPrice);
    }
}