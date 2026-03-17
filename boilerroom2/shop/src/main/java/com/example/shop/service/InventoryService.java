package com.example.shop.service;

import com.example.shop.entity.Inventory;
import com.example.shop.entity.Product;
import com.example.shop.repository.InventoryRepository;
import com.example.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepo;
    private final ProductRepository productRepo;

    public InventoryService(
            InventoryRepository inventoryRepo,
            ProductRepository productRepo) {

        this.inventoryRepo = inventoryRepo;
        this.productRepo = productRepo;
    }

    public Inventory create(Long productId, int quantity) {

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventory.setQuantity(quantity);

        return inventoryRepo.save(inventory);
    }

    public void decreaseStock(Product product, int quantity) {

        Inventory inventory = inventoryRepo
                .findByProduct(product)
                .orElseThrow(() -> new RuntimeException("Inventory missing"));

        if (inventory.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock");
        }

        inventory.setQuantity(inventory.getQuantity() - quantity);

        inventoryRepo.save(inventory);
    }
}