package com.example.shop.dto.v2.order;

public record OrderResponseDto(
        Long id,
        Long customerId,
        int totalPrice
) {}