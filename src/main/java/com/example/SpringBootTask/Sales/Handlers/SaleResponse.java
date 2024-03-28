package com.example.SpringBootTask.Sales.Handlers;

import com.example.SpringBootTask.Products.Entities.Product;
import com.example.SpringBootTask.Sales.Entities.Sale;

import java.util.List;

public class SaleResponse {
    private List<Sale> sales;

    public SaleResponse() {
    }

    public SaleResponse(List<Sale> sales) {
        this.sales = sales;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
