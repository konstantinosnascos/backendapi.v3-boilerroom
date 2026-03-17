package com.example.shop.service;

import com.example.shop.entity.Product;
import com.example.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product create(String name, int price) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        return repo.save(product);
    }

    public Product getById(Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}