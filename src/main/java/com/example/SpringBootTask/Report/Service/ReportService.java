package com.example.SpringBootTask.Report.Service;

import com.example.SpringBootTask.Clients.Entity.Client;
import com.example.SpringBootTask.Report.Models.ClientsReport;
import com.example.SpringBootTask.Report.Models.ProductsReport;
import com.example.SpringBootTask.Report.Models.SalesReport;
import com.example.SpringBootTask.Report.Service.DetailedService.ClientReportService;
import com.example.SpringBootTask.Report.Service.DetailedService.ProductReportService;
import com.example.SpringBootTask.Report.Service.DetailedService.SaleReportService;
import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Entities.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    private SaleReportService saleReportService;
    @Autowired
    private ClientReportService clientReportService;
    @Autowired
    private ProductReportService productReportService;
    public SalesReport generateSalesReport(LocalDateTime startDate, LocalDateTime endDate) {
        List<Sale> sales = saleReportService.getSalesByDateRange(startDate, endDate);
        int totalSales = sales.size();

        double totalRevenue = sales.stream()
                .mapToDouble(Sale::getTotal)
                .sum();

        Map<String, Long> salesByProductCategory = saleReportService.getSalesByProductCategory(startDate, endDate);
        List<String> topSellingProducts = salesByProductCategory.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Seller> topPerformingSellers = saleReportService.getTopPerformingSellers(startDate, endDate);

        return new SalesReport(totalSales, totalRevenue, topSellingProducts, topPerformingSellers);
    }
    public ClientsReport generateClientReport() {
        Long totalClients = clientReportService.getTotalClients();
        List<Client> topSpendingClients = clientReportService.getTopSpendingClients(10);
        Map<String, Integer> clientActivity = clientReportService.getClientActivity();
        Map<String, Integer> clientLocationStatistics = clientReportService.getClientLocationStatistics();

        return new ClientsReport(totalClients, topSpendingClients, clientActivity, clientLocationStatistics);
    }
    public ProductsReport generateProductReport() {
        Map<String, Integer> inventoryStatus = productReportService.calculateInventoryStatus();
        Map<String, Object> salesPerformance = productReportService.calculateSalesPerformance();
        Map<String, Double> pricingAnalysis = productReportService.calculatePricingAnalysis();

        return new ProductsReport(inventoryStatus, salesPerformance, pricingAnalysis);
    }
}
