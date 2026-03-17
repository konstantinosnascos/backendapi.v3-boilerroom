package com.example.shop.controller.v2;

import com.example.shop.dto.v1.customer.CustomerCreateDto;
import com.example.shop.dto.v1.customer.CustomerResponseDto;
import com.example.shop.entity.Customer;
import com.example.shop.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/customers")
public class CustomerController2 {

    private final CustomerService service;

    public CustomerController2(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerResponseDto create(@RequestBody CustomerCreateDto dto) {

        Customer customer = service.create(dto.name(), dto.email());

        return new CustomerResponseDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );
    }

    @GetMapping("/{id}")
    public CustomerResponseDto get(@PathVariable Long id) {

        Customer customer = service.getById(id);

        return new CustomerResponseDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );
    }
}