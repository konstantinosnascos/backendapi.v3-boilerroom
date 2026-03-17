package com.example.shop.dto.v2.product;

public record ProductCreateDto(
        String name,
        int price,
        String currency
) {}