package com.example.SpringBootTask.Sales.Repository;

import com.example.SpringBootTask.Sales.Entities.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem,Long> {

}
