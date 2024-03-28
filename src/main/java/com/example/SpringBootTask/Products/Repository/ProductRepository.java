package com.example.SpringBootTask.Products.Repository;

import com.example.SpringBootTask.Products.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
