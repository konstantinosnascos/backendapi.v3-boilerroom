package com.example.shop.service;

import com.example.shop.entity.Customer;
import com.example.shop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public Customer create(String name, String email) {

        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);

        return repo.save(c);
    }

    public Customer getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}