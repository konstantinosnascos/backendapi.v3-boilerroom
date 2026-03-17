
package com.example.shop.controller.v2;

import com.example.shop.dto.v1.Inventory.InventoryCreateDto;
import com.example.shop.entity.Inventory;
import com.example.shop.service.InventoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping
    public Inventory create(@RequestBody InventoryCreateDto dto) {
        return service.create(dto.productId(), dto.quantity());
    }
}