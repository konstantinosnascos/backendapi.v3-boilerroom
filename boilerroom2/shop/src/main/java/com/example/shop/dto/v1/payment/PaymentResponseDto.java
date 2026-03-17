package com.example.shop.dto.v1.payment;

public record PaymentResponseDto(
        Long id,
        Long orderId,
        String status
) {}