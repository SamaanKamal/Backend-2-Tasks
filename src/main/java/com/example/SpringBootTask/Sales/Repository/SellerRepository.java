package com.example.SpringBootTask.Sales.Repository;

import com.example.SpringBootTask.Sales.Entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
}
