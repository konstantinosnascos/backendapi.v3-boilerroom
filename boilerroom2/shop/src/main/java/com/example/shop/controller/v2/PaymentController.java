package com.example.shop.controller.v2;

import com.example.shop.entity.Payment;
import com.example.shop.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/{orderId}")
    public String pay(@PathVariable Long orderId) {

        service.pay(orderId);

        return "Payment completed";
    }

    @GetMapping("/{id}")
    public Payment get(@PathVariable Long id) {
        return service.getById(id);
    }
}