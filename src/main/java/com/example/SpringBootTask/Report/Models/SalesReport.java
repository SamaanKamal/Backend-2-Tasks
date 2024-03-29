package com.example.SpringBootTask.Report.Models;

import com.example.SpringBootTask.Sales.Entities.Seller;

import java.util.List;

public class SalesReport {
    private int totalSales;
    private double totalRevenue;
    private List<String> topSellingProducts;
    private List<Seller> topPerformingSellers;

    public SalesReport() {
    }

    public SalesReport(int totalSales, double totalRevenue, List<String> topSellingProducts, List<Seller> topPerformingSellers) {
        this.totalSales = totalSales;
        this.totalRevenue = totalRevenue;
        this.topSellingProducts = topSellingProducts;
        this.topPerformingSellers = topPerformingSellers;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public List<String> getTopSellingProducts() {
        return topSellingProducts;
    }

    public List<Seller> getTopPerformingSellers() {
        return topPerformingSellers;
    }
}
