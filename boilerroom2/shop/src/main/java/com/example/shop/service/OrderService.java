package com.example.shop.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.shop.entity.Customer;
import com.example.shop.entity.Order;
import com.example.shop.entity.OrderItem;
import com.example.shop.entity.Product;
import com.example.shop.repository.CustomerRepository;
import com.example.shop.repository.OrderItemRepository;
import com.example.shop.repository.OrderRepository;
import com.example.shop.repository.ProductRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;
    private final OrderItemRepository orderItemRepo;
    private final InventoryService inventoryService;
    private final CustomerService customerService;

    public OrderService(
            OrderRepository orderRepo,
            CustomerRepository customerRepo,
            CustomerService customerService,
            ProductRepository productRepo,
            OrderItemRepository orderItemRepo,
            InventoryService inventoryService) {

        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.customerService = customerService;
        this.productRepo = productRepo;
        this.orderItemRepo = orderItemRepo;
        this.inventoryService = inventoryService;
    }

    public Order createOrder(Long customerId) {

        Customer customer = customerService.getById(customerId);

        Order order = new Order();
        order.setCustomer(customer);

        return orderRepo.save(order);
    }

    public void addItem(Long orderId, Long productId, int quantity) {

        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found"));

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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }
}