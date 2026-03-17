package com.example.shop.service;

import com.example.shop.entity.Order;
import com.example.shop.entity.Payment;
import com.example.shop.repository.OrderRepository;
import com.example.shop.repository.PaymentRepository;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepo;
    private final OrderRepository orderRepo;

    public PaymentService(
            PaymentRepository paymentRepo,
            OrderRepository orderRepo) {

        this.paymentRepo = paymentRepo;
        this.orderRepo = orderRepo;
    }

    public Payment pay(Long orderId) {

        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (paymentRepo.existsByOrder(order)) {
            throw new RuntimeException("Order already paid");
        }

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setStatus("PAID");

        return paymentRepo.save(payment);
    }

    public Payment getById(Long id) {

        return paymentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }
}