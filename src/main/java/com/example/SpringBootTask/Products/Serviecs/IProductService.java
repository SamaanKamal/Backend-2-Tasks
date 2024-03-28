package com.example.SpringBootTask.Products.Serviecs;

import com.example.SpringBootTask.Products.Entities.Product;
import com.example.SpringBootTask.Products.Handlers.ProductRequest;

import java.util.List;

public interface IProductService {
    public List<Product> getAllProducts();
    public void createProduct(ProductRequest productRequest);
    public void updateProduct(Long productId, ProductRequest productRequest);
    public void deleteProduct(Long productId);
}
