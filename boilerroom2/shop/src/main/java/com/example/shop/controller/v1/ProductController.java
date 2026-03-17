package com.example.shop.controller.v1;

import com.example.shop.dto.v1.product.ProductCreateDto;
import com.example.shop.dto.v1.product.ProductResponseDto;
import com.example.shop.entity.Product;
import com.example.shop.service.ProductService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductResponseDto create(@RequestBody ProductCreateDto dto) {

        Product product = service.create(dto.name(), dto.price());

        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    @GetMapping("/{id}")
    public ProductResponseDto get(@PathVariable Long id) {

        Product product = service.getById(id);

        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}