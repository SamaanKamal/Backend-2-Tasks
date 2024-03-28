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


    @GetMapping
    public ResponseEntity<ClientResponse> fetchClients() {
        List<Client> clients = clientService.getAllClients();
        if(clients==null)
        {
            return ResponseEntity.notFound().build();
        }
        ClientResponse response = new ClientResponse(clients);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/createClient")
    public ResponseEntity<String> createClient(@RequestBody ClientRequest clientRequest) {
        if(clientRequest==null){
            return ResponseEntity.badRequest().body("Bad Request data");
        }
        clientService.createClient(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Client Data Created Successfully");
    }
    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClient(@PathVariable Long clientId, @RequestBody ClientRequest clientRequest) {
        if(clientRequest==null|| clientId ==null){
            return ResponseEntity.badRequest().body("Bad Request data");
        }
        clientService.updateClient(clientId, clientRequest);
        return ResponseEntity.ok().body("Client data Updated successfully");
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClient(@PathVariable Long clientId) {
        if(clientId==null){
            return ResponseEntity.badRequest().body("Bad Request data");
        }
        clientService.deleteClient(clientId);
        return ResponseEntity.ok().body("Client Data Deleted Successfully");
    }
}
