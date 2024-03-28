package com.example.SpringBootTask.Sales.Services;

import com.example.SpringBootTask.Sales.Entities.Seller;
import com.example.SpringBootTask.Sales.Handlers.SellerRequest;
import com.example.SpringBootTask.Sales.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService implements ISellerService{
    @Autowired
    private SellerRepository sellerRepository;
    @Override
    public void createSeller(SellerRequest sellerRequest) {
        Seller seller = new Seller();
        seller.setName(sellerRequest.getName());
        sellerRepository.save(seller);
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }
}
