package com.example.shop.dto.v1.Inventory;

public record InventoryCreateDto(
        Long productId,
        int quantity
) {}