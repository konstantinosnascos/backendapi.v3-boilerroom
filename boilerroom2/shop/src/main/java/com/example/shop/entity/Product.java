package com.example.shop.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private String Currency = "SEK";


    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "product")
    private Inventory inventory;

    public Product() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getCurrency() {
        return Currency;
    }

    public String setCurrency(String currency) {
        return Currency = currency;
    }




}