package com.example.SpringBootTask.Sales.Handlers;

import com.example.SpringBootTask.Products.Entities.Product;
import com.example.SpringBootTask.Sales.Entities.Sale;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class SaleItemRequest {
    private Sale sale;

    private Product product;

    private int quantity;
    private Double price;

    public SaleItemRequest() {
    }

    public SaleItemRequest(Sale sale, Product product, int quantity, Double price) {
        this.sale = sale;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
