package com.example.SpringBootTask.Report.Service.DetailedService;

import com.example.SpringBootTask.Products.Entities.Product;
import com.example.SpringBootTask.Products.Repository.ProductRepository;
import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class ProductReportService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SaleRepository saleRepository;

    public Map<String, Integer> calculateInventoryStatus() {
        Map<String, Integer> inventoryStatus = new HashMap<>();
        List<Product> products = productRepository.findAll();
        int totalProducts = products.size();
        int totalAvailableProducts = products.stream()
                .mapToInt(Product::getAvailableQuantity)
                .sum();
        int totalUnavailableProducts = totalProducts - totalAvailableProducts;
        inventoryStatus.put("totalProducts", totalProducts);
        inventoryStatus.put("totalAvailableProducts", totalAvailableProducts);
        inventoryStatus.put("totalUnavailableProducts", totalUnavailableProducts);
        return inventoryStatus;
    }

    public Map<String, Object> calculateSalesPerformance() {
        Map<String, Object> salesPerformance = new HashMap<>();
        Long totalSales = saleRepository.count();
        double totalRevenue = calculateTotalRevenue();
        salesPerformance.put("totalSales", totalSales);
        salesPerformance.put("totalRevenue", totalRevenue);
        return salesPerformance;
    }

    public Map<String, Double> calculatePricingAnalysis() {
        Map<String, Double> pricingAnalysis = new HashMap<>();
        List<Product> products = productRepository.findAll();
        double averagePrice = products.stream().mapToDouble(Product::getPrice).average().orElse(0);
        double minPrice = products.stream().mapToDouble(Product::getPrice).min().orElse(0);
        double maxPrice = products.stream().mapToDouble(Product::getPrice).max().orElse(0);
        pricingAnalysis.put("averagePrice", averagePrice);
        pricingAnalysis.put("minPrice", minPrice);
        pricingAnalysis.put("maxPrice", maxPrice);
        return pricingAnalysis;
    }
    private double calculateTotalRevenue() {
        List<Sale> sales = saleRepository.findAll();
        double totalRevenue = 0.0;
        for (Sale sale : sales) {
            totalRevenue += sale.getTotal();
        }
        return totalRevenue;
    }
}
