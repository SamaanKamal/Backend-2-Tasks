package com.example.SpringBootTask.Report.Controller;

import com.example.SpringBootTask.Report.Models.ClientsReport;
import com.example.SpringBootTask.Report.Models.ProductsReport;
import com.example.SpringBootTask.Report.Models.SalesReport;
import com.example.SpringBootTask.Report.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/salesReport")
    public SalesReport generateSalesReport(@RequestParam("startDate") LocalDateTime startDate,
                                           @RequestParam("endDate") LocalDateTime endDate) {
        return reportService.generateSalesReport(startDate, endDate);
    }

    @GetMapping("/clientsReport")
    public ClientsReport generateClientReport() {
        return reportService.generateClientReport();
    }

    @GetMapping("/productsReport")
    public ProductsReport generateProductReport() {
        return reportService.generateProductReport();
    }
}
