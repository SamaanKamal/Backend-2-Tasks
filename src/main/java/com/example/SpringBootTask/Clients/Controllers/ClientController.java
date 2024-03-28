package com.example.SpringBootTask.Clients.Controllers;

import com.example.SpringBootTask.Clients.Entity.Client;
import com.example.SpringBootTask.Clients.Handlers.ClientRequest;
import com.example.SpringBootTask.Clients.Handlers.ClientResponse;
import com.example.SpringBootTask.Clients.Serviecs.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private IClientService clientService;

    // Fetch Products
    @GetMapping
    public ResponseEntity<ClientResponse> fetchClients() {
        List<Client> clients = clientService.getAllClients();
        ClientResponse response = new ClientResponse(clients);
        return ResponseEntity.ok(response);
    }

    // Create Product
    @PostMapping("/createClient")
    public ResponseEntity<Void> createClient(@RequestBody ClientRequest clientRequest) {
        clientService.createClient(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Update Product
    @PutMapping("/{clientId}")
    public ResponseEntity<Void> updateClient(@PathVariable Long clientId, @RequestBody ClientRequest clientRequest) {
        clientService.updateClient(clientId, clientRequest);
        return ResponseEntity.ok().build();
    }

    // Delete Product
    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }
}
