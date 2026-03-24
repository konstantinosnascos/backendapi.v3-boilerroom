package com.example.shop.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.shop.entity.Product;
import com.example.shop.repository.ProductRepository;

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
        product.setCurrency("SEK");
 
        
        return repo.save(product);
    }

    public Product getById(Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found"));
    }

    public List<Product> getAll(){
        return repo.findAll();
    }


}