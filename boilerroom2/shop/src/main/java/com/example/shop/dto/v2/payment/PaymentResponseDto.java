package com.example.shop.dto.v2.payment;

public record PaymentResponseDto(
        Long id,
        Long orderId,
        String status
) {}