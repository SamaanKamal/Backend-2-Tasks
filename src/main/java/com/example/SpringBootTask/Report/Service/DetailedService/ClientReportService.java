package com.example.SpringBootTask.Report.Service.DetailedService;

import com.example.SpringBootTask.Clients.Entity.Client;
import com.example.SpringBootTask.Clients.Repository.ClientRepository;
import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClientReportService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private SaleRepository saleRepository;

    public Long getTotalClients() {
        return clientRepository.count();
    }

    public List<Client> getTopSpendingClients(int limit) {
        List<Sale> sales = saleRepository.findAll();

        Map<Client, Double> clientSpending = sales.stream()
                .collect(Collectors.groupingBy(Sale::getClient, Collectors.summingDouble(Sale::getTotal)));

        return clientSpending.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getClientActivity() {
        List<Sale> sales = saleRepository.findAll();

        Map<String, Long> clientActivity = sales.stream()
                .collect(Collectors.groupingBy(sale -> sale.getClient().getName(), Collectors.counting()));

        return clientActivity.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().intValue()));
    }

    public Map<String, Integer> getClientLocationStatistics() {
        List<Client> clients = clientRepository.findAll();

        Map<String, Long> clientLocationStats = clients.stream()
                .collect(Collectors.groupingBy(Client::getAddress, Collectors.counting()));

        return clientLocationStats.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().intValue()));
    }
}
