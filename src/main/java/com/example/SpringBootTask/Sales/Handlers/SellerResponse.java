package com.example.SpringBootTask.Sales.Handlers;

import com.example.SpringBootTask.Sales.Entities.Seller;

import java.util.List;

public class SellerResponse {
    private List<Seller> sellers;

    public SellerResponse() {
    }

    public SellerResponse(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }
}
