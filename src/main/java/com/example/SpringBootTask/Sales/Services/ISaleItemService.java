package com.example.SpringBootTask.Sales.Services;

import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Entities.SaleItem;
import com.example.SpringBootTask.Sales.Handlers.SaleItemRequest;
import com.example.SpringBootTask.Sales.Handlers.SaleRequest;

import java.util.List;

public interface ISaleItemService {
    List<SaleItem> getAllSaleItems();
    void createSaleItems(SaleItemRequest saleItemRequest);
    void updateSaleItem(Long saleItemId, SaleItemRequest saleItemRequest);
    void deleteSaleItem(Long saleItemId);

}
