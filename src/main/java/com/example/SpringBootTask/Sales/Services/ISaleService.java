package com.example.SpringBootTask.Sales.Services;

import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Entities.SaleItem;
import com.example.SpringBootTask.Sales.Handlers.SaleRequest;

import java.util.List;

public interface ISaleService {
    List<Sale> getAllSales();
    void createSale(SaleRequest saleRequest, List<SaleItem> saleItems);
    void updateSale(SaleRequest saleRequest,Long saleId);
    void deleteSale(Long saleId);

}
