package com.example.shop.dto.v2.inventory;

public record InventoryCreateDto(
        Long productId,
        int quantity
) {}