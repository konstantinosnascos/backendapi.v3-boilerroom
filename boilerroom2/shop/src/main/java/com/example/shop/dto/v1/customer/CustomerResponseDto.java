package com.example.shop.dto.v1.customer;

public record CustomerResponseDto(
        Long id,
        String name,
        String email
) {}