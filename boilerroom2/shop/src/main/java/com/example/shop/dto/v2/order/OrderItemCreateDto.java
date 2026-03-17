package com.example.shop.dto.v2.order;

public record OrderItemCreateDto(
        Long productId,
        int quantity
) {}