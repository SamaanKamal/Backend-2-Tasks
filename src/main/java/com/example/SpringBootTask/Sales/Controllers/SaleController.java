package com.example.SpringBootTask.Sales.Controllers;

import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Entities.SaleItem;
import com.example.SpringBootTask.Sales.Handlers.SaleRequest;
import com.example.SpringBootTask.Sales.Handlers.SaleResponse;
import com.example.SpringBootTask.Sales.Services.ISaleItemService;
import com.example.SpringBootTask.Sales.Services.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired
    ISaleService saleService;
    @Autowired
    ISaleItemService saleItemService;
    @GetMapping
    public ResponseEntity<SaleResponse> fetchSales() {
        List<Sale> sales = saleService.getAllSales();
        if(sales!= null){
            SaleResponse response = new SaleResponse(sales);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    // Create Product
    @PostMapping("/createSale")
    public ResponseEntity<String> createSale(@RequestBody SaleRequest saleRequest) {
        List<SaleItem> saleItems =saleItemService.getAllSaleItems();
        if(saleItems!=null){
            saleService.createSale(saleRequest,saleItems);
            return ResponseEntity.status(HttpStatus.CREATED).body("Sale Created Successfully");
        }
        return ResponseEntity.badRequest().body("Something is wrong with sale items");
    }

    // Update Product
    @PutMapping("/{saleId}")
    public ResponseEntity<String> updateSale(@PathVariable Long saleId, @RequestBody SaleRequest saleRequest) {
        if(saleId == null|| saleRequest==null){
            return ResponseEntity.badRequest().body("Something is wrong with the Request data");
        }
        saleService.updateSale(saleRequest, saleId);
        return ResponseEntity.ok().body("Sale Updated Successfully");
    }

    // Delete Product
    @DeleteMapping("/{saleId}")
    public ResponseEntity<String> deleteSale(@PathVariable Long saleId) {
        if(saleId==null)
        {
            return ResponseEntity.badRequest().body("Something is wrong with Request data");
        }
        saleService.deleteSale(saleId);
        return ResponseEntity.ok().body("Sale Deleted Successfully");
    }

}
