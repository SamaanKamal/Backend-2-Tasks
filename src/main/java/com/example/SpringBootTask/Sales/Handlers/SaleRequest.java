package com.example.SpringBootTask.Sales.Handlers;

import com.example.SpringBootTask.Clients.Entity.Client;
import com.example.SpringBootTask.Sales.Entities.Seller;

public class SaleRequest {
    private Client client;
    private Seller seller;
    private Double total;

    public SaleRequest() {
    }

    public SaleRequest(Client client, Seller seller, Double total) {
        this.client = client;
        this.seller = seller;
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
