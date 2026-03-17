
package com.example.shop.controller.v1;

import com.example.shop.dto.v1.Inventory.InventoryCreateDto;
import com.example.shop.entity.Inventory;
import com.example.shop.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
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