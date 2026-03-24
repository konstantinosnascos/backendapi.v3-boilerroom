package com.example.shop.controller.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.dto.v2.product.ProductCreateDto;
import com.example.shop.dto.v2.product.ProductResponseDto;
import com.example.shop.entity.Product;
import com.example.shop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v2/products")
public class ProductController2 {

    private final ProductService service;

    public ProductController2(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductResponseDto create(@RequestBody ProductCreateDto dto) {

        Product product = service.create(dto.name(), dto.price());

        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCurrency()

                

        );
    }

    @GetMapping("/{id}")
    public ProductResponseDto get(@PathVariable Long id) {

        Product product = service.getById(id);

        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(), 
                product.getCurrency()
        );
    }

    @GetMapping
    public List<ProductResponseDto> getAll() {
        return service.getAll().stream()
                .map(product -> new ProductResponseDto(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getCurrency()))
                .toList();
    }
}