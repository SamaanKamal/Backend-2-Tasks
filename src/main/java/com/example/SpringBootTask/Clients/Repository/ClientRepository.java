package com.example.SpringBootTask.Clients.Repository;

import com.example.SpringBootTask.Clients.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
