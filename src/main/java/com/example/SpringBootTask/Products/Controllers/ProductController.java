package com.example.SpringBootTask.Products.Controllers;

import com.example.SpringBootTask.Products.Entities.Product;
import com.example.SpringBootTask.Products.Handlers.ProductRequest;
import com.example.SpringBootTask.Products.Handlers.ProductResponse;
import com.example.SpringBootTask.Products.Serviecs.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<ProductResponse> fetchProducts() {
        List<Product> products = productService.getAllProducts();
        if(products==null){
            return ResponseEntity.notFound().build();
        }
        ProductResponse response = new ProductResponse(products);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {
        if(productRequest==null){
            return ResponseEntity.badRequest().body("Bad Request data");
        }
        productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product Created Successfully");
    }

    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable Long productId, @RequestBody ProductRequest productRequest) {
        if(productId==null|| productRequest ==null){
            return ResponseEntity.badRequest().body("Bad Request data");
        }
        productService.updateProduct(productId, productRequest);
        return ResponseEntity.ok().body("Product Updated Successfully");
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        if(productId==null){
            return ResponseEntity.badRequest().body("Bad Request data");
        }
        productService.deleteProduct(productId);
        return ResponseEntity.ok().body("Product Deleted Successfully");
    }
}
