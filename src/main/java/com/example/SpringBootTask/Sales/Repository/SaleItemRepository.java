package com.example.SpringBootTask.Sales.Repository;

import com.example.SpringBootTask.Sales.Entities.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleItemRepository extends JpaRepository<SaleItem,Long> {
    List<SaleItem> findBySaleCreationDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
