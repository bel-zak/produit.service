package com.commerce.produit.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int stockQuantity;
    private double price;

    public Long id() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public int stockQuantity() {
        return stockQuantity;
    }

    public Product setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        return this;
    }

    public double price() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }
}
