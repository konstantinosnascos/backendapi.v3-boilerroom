package com.example.shop.dto.v2.customer;

public record CustomerResponseDto(
        Long id,
        String name,
        String email
) {}