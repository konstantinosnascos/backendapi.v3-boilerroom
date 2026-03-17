package com.example.shop.service;

import com.example.shop.entity.*;
import com.example.shop.repository.*;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;
    private final OrderItemRepository orderItemRepo;
    private final InventoryService inventoryService;

    public OrderService(
            OrderRepository orderRepo,
            CustomerRepository customerRepo,
            ProductRepository productRepo,
            OrderItemRepository orderItemRepo,
            InventoryService inventoryService) {

        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
        this.orderItemRepo = orderItemRepo;
        this.inventoryService = inventoryService;
    }

    public Order createOrder(Long customerId) {

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order order = new Order();
        order.setCustomer(customer);

        return orderRepo.save(order);
    }

    public void addItem(Long orderId, Long productId, int quantity) {

        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        inventoryService.decreaseStock(product, quantity);

        OrderItem item = new OrderItem();

        item.setOrder(order);
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setPriceAtPurchase(product.getPrice());

        orderItemRepo.save(item);
    }

    public Order getById(Long id) {

        return orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}