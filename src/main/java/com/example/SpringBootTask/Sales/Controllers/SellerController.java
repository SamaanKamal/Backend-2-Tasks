package com.example.SpringBootTask.Sales.Controllers;

import com.example.SpringBootTask.Sales.Entities.Sale;
import com.example.SpringBootTask.Sales.Entities.SaleItem;
import com.example.SpringBootTask.Sales.Entities.Seller;
import com.example.SpringBootTask.Sales.Handlers.SaleRequest;
import com.example.SpringBootTask.Sales.Handlers.SaleResponse;
import com.example.SpringBootTask.Sales.Handlers.SellerRequest;
import com.example.SpringBootTask.Sales.Handlers.SellerResponse;
import com.example.SpringBootTask.Sales.Services.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    @Autowired
    private ISellerService sellerService;

    @GetMapping
    public ResponseEntity<SellerResponse> fetchSellers() {
        List<Seller> sellers = sellerService.getAllSellers();
        if(sellers!= null){
            SellerResponse response = new SellerResponse(sellers);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/createSeller")
    public ResponseEntity<String> createSeller(@RequestBody SellerRequest sellerRequest) {

        if(sellerRequest==null){
            return ResponseEntity.badRequest().body("Bad Request data");
        }
        sellerService.createSeller(sellerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Seller Created Successfully");
    }

}
