package com.example.SpringBootTask.Sales.Handlers;

import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Entities.SaleItem;

import java.util.List;

public class SaleItemResponse {
    private List<SaleItem> saleItems;

    public SaleItemResponse() {
    }

    public SaleItemResponse(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }
}
