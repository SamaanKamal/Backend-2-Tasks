package com.example.SpringBootTask.Sales.Services;

import com.example.SpringBootTask.Sales.Entities.Seller;
import com.example.SpringBootTask.Sales.Handlers.SellerRequest;

import java.util.List;

public interface ISellerService {
    void createSeller(SellerRequest sellerRequest);
    List<Seller> getAllSellers();
}
