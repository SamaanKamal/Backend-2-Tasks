package com.example.SpringBootTask.Report.Models;

import java.util.Map;

public class ProductsReport {
    private Map<String, Integer> inventoryStatus;
    private Map<String, Object> salesPerformance;
    private Map<String, Double> pricingAnalysis;

    public ProductsReport() {
    }

    public ProductsReport(Map<String, Integer> inventoryStatus, Map<String, Object> salesPerformance, Map<String, Double> pricingAnalysis) {
        this.inventoryStatus = inventoryStatus;
        this.salesPerformance = salesPerformance;
        this.pricingAnalysis = pricingAnalysis;
    }

    public Map<String, Integer> getInventoryStatus() {
        return inventoryStatus;
    }

    public Map<String, Object> getSalesPerformance() {
        return salesPerformance;
    }

    public Map<String, Double> getPricingAnalysis() {
        return pricingAnalysis;
    }
}
