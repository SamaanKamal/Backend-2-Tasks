package com.example.SpringBootTask.Sales.Services;

import com.example.SpringBootTask.Products.Entities.Product;
import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Entities.SaleItem;
import com.example.SpringBootTask.Sales.Handlers.SaleItemRequest;
import com.example.SpringBootTask.Sales.Repository.SaleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleItemService implements ISaleItemService{
    @Autowired
    private SaleItemRepository saleItemRepository;


    @Override
    public List<SaleItem> getAllSaleItems() {
        return saleItemRepository.findAll();
    }

    @Override
    public void createSaleItems(SaleItemRequest saleItemRequest) {
        SaleItem saleItem = new SaleItem();
        Sale sale = saleItemRequest.getSale();
        Product product =saleItemRequest.getProduct();
        int quantity = saleItemRequest.getQuantity();
        Double price = saleItemRequest.getPrice();
        saleItem.setSale(sale);
        saleItem.setProduct(product);
        saleItem.setQuantity(quantity);
        saleItem.setPrice(price);
        saleItemRepository.save(saleItem);
    }

    @Override
    public void updateSaleItem(Long saleItemId, SaleItemRequest saleItemRequest) {
        SaleItem saleItem = saleItemRepository.findById(saleItemId)
                .orElseThrow(() -> new RuntimeException("Sale Item was not found with this id"));

        saleItem.setQuantity(saleItemRequest.getQuantity());
        saleItem.setPrice(saleItem.getPrice());
        saleItem.setSale(saleItemRequest.getSale());
        saleItem.setProduct(saleItemRequest.getProduct());
        saleItemRepository.save(saleItem);
    }

    @Override
    public void deleteSaleItem(Long saleItemId) {
        saleItemRepository.deleteById(saleItemId);
    }
}
