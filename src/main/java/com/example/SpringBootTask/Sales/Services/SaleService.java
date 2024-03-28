package com.example.SpringBootTask.Sales.Services;

import com.example.SpringBootTask.Clients.Entity.Client;
import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Entities.SaleItem;
import com.example.SpringBootTask.Sales.Entities.Seller;
import com.example.SpringBootTask.Sales.Handlers.SaleRequest;
import com.example.SpringBootTask.Sales.Repository.SaleItemRepository;
import com.example.SpringBootTask.Sales.Repository.SaleRepository;
import com.example.SpringBootTask.Sales.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService  implements ISaleService{
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleItemRepository saleItemRepository;

    @Autowired
    private SellerRepository sellerRepository;


    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public void createSale(SaleRequest saleRequest, List<SaleItem> saleItems) {
        Seller seller = saleRequest.getSeller();
        Client client = saleRequest.getClient();
        Sale sale= new Sale();
        sale.setSeller(seller);
        sale.setClient(client);

        double total = 0;
        for (SaleItem item : saleItems) {
            total += item.getQuantity() * item.getPrice();
            item.setSale(sale);
        }
        sale.setTotal(total);

        // Save sale and associated items
        Sale savedSale = saleRepository.save(sale);
        saleItemRepository.saveAll(saleItems);
    }

    @Override
    public void updateSale(SaleRequest saleRequest, Long saleId) {
        Sale sale = saleRepository.findById(saleId).orElseThrow(()->new RuntimeException("there is no sale with the associated id"));
        sale.setClient(saleRequest.getClient());
        sale.setSeller(saleRequest.getSeller());
        sale.setTotal(saleRequest.getTotal());
        saleRepository.save(sale);
    }

    @Override
    public void deleteSale(Long saleId) {
        Sale sale = saleRepository.findById(saleId).orElseThrow(()-> new RuntimeException("there is no sale with the associated id"));
        saleItemRepository.deleteById(saleId);
        saleRepository.delete(sale);
    }
}
