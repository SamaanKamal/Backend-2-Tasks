package com.example.SpringBootTask.Sales.Repository;

import com.example.SpringBootTask.Sales.Entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {
}
