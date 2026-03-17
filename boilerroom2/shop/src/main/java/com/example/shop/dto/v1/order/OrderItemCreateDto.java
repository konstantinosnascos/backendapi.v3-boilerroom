package com.example.shop.dto.v1.order;

public record OrderItemCreateDto(
        Long productId,
        int quantity
) {}