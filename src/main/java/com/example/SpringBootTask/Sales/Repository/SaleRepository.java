package com.example.SpringBootTask.Sales.Repository;

import com.example.SpringBootTask.Sales.Entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale,Long> {
    List<Sale> findByCreationDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
