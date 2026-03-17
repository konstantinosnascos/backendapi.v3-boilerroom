package com.example.shop.repository;

import com.example.shop.entity.Order;
import com.example.shop.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    boolean existsByOrder(Order order);
}
