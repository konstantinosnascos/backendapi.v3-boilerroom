package com.example.shop.dto.v1.product;

public record ProductResponseDto(
        Long id,
        String name,
        int price
) {}