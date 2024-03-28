package com.example.SpringBootTask.Sales.Controllers;

import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Entities.SaleItem;
import com.example.SpringBootTask.Sales.Handlers.SaleItemRequest;
import com.example.SpringBootTask.Sales.Handlers.SaleItemResponse;
import com.example.SpringBootTask.Sales.Services.ISaleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saleItems")
public class SaleItemController {
    @Autowired
    ISaleItemService saleItemService;
    @GetMapping
    public ResponseEntity<SaleItemResponse> fetchSaleItems() {
        List<SaleItem> saleItems = saleItemService.getAllSaleItems();
        if(saleItems== null) {
            return ResponseEntity.notFound().build();
        }
        SaleItemResponse response = new SaleItemResponse(saleItems);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/createSaleItem")
    public ResponseEntity<String> createSaleItem(@RequestBody SaleItemRequest saleItemRequest) {
        if(saleItemRequest==null) {
            return ResponseEntity.badRequest().body("Something is wrong with the Request data");
        }
        saleItemService.createSaleItems(saleItemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sale Item Created Successfully");
    }

    // Update Product
    @PutMapping("/{saleItemId}")
    public ResponseEntity<String> updateSaleItem(@PathVariable Long saleItemId, @RequestBody SaleItemRequest saleItemRequest) {
        if(saleItemId == null|| saleItemRequest==null){
            return ResponseEntity.badRequest().body("Something is wrong with the Request data");
        }
        saleItemService.updateSaleItem(saleItemId, saleItemRequest);
        return ResponseEntity.ok().body("Sale Item Updated Successfully");
    }

    // Delete Product
    @DeleteMapping("/{saleItemId}")
    public ResponseEntity<String> deleteSaleItem(@PathVariable Long saleItemId) {
        if(saleItemId==null)
        {
            return ResponseEntity.badRequest().body("Something is wrong with Request data");
        }
        saleItemService.deleteSaleItem(saleItemId);
        return ResponseEntity.ok().body("Sale Item Deleted Successfully");
    }

}
