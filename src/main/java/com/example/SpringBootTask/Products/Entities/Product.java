package com.example.SpringBootTask.Products.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="category")
    private String category;
    @Column(name = "creation_date")
    private final LocalDateTime creationDate = LocalDateTime.now();
    @Column(name = "available_quantity")
    private int availableQuantity;
    @Column(name = "price")
    private double price;

    public Product() {
    }

    public Product(String name, String description, String category, int availableQuantity, double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.availableQuantity = availableQuantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
