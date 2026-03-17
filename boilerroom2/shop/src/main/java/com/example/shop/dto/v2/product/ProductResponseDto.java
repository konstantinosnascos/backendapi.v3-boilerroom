package com.example.shop.dto.v2.product;

public record ProductResponseDto(
        Long id,
        String name,
        int price,
        String currency
) {}