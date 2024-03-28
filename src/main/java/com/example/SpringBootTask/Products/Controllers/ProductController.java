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

    // Fetch Products
    @GetMapping
    public ResponseEntity<ProductResponse> fetchProducts() {
        List<Product> products = productService.getAllProducts();
        ProductResponse response = new ProductResponse(products);
        return ResponseEntity.ok(response);
    }

    // Create Product
    @PostMapping("/createProduct")
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Update Product
    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long productId, @RequestBody ProductRequest productRequest) {
        productService.updateProduct(productId, productRequest);
        return ResponseEntity.ok().build();
    }

    // Delete Product
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
