package com.example.SpringBootTask.Report.Service.DetailedService;

import com.example.SpringBootTask.Products.Entities.Product;
import com.example.SpringBootTask.Report.Models.SalesReport;
import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Entities.SaleItem;
import com.example.SpringBootTask.Sales.Entities.Seller;
import com.example.SpringBootTask.Sales.Repository.SaleItemRepository;
import com.example.SpringBootTask.Sales.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SaleReportService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleItemRepository saleItemRepository;
    public List<Sale> getSalesByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return saleRepository.findByCreationDateBetween(startDate, endDate);
    }

    public List<Seller> getTopPerformingSellers(LocalDateTime startDate, LocalDateTime endDate) {
        List<Sale> sales = saleRepository.findByCreationDateBetween(startDate, endDate);


        Map<Seller, Double> sellerSales = sales.stream()
                .collect(Collectors.groupingBy(Sale::getSeller, Collectors.summingDouble(Sale::getTotal)));


        return sellerSales.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    public Map<String, Long> getSalesByProductCategory(LocalDateTime startDate, LocalDateTime endDate) {
        List<SaleItem> saleItems = saleItemRepository.findBySaleCreationDateBetween(startDate, endDate);

        Map<String, Long> salesByCategory = saleItems.stream()
                .map(SaleItem::getProduct)
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));

        return salesByCategory;
    }


}
