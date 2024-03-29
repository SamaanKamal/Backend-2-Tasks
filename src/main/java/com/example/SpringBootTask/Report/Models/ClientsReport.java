package com.example.SpringBootTask.Report.Models;


import com.example.SpringBootTask.Clients.Entity.Client;

import java.util.List;
import java.util.Map;

public class ClientsReport {
    private Long totalClients;
    private List<Client> topSpendingClients;
    private Map<String, Integer> clientActivity;
    private Map<String, Integer> clientLocationStatistics;

    public ClientsReport() {
    }

    // Constructor
    public ClientsReport(Long totalClients, List<Client> topSpendingClients,
                        Map<String, Integer> clientActivity, Map<String, Integer> clientLocationStatistics) {
        this.totalClients = totalClients;
        this.topSpendingClients = topSpendingClients;
        this.clientActivity = clientActivity;
        this.clientLocationStatistics = clientLocationStatistics;
    }

    public Long getTotalClients() {
        return totalClients;
    }

    public List<Client> getTopSpendingClients() {
        return topSpendingClients;
    }

    public Map<String, Integer> getClientActivity() {
        return clientActivity;
    }

    public Map<String, Integer> getClientLocationStatistics() {
        return clientLocationStatistics;
    }
}
