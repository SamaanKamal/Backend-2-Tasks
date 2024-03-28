package com.example.SpringBootTask.Clients.Serviecs;

import com.example.SpringBootTask.Clients.Entity.Client;
import com.example.SpringBootTask.Clients.Handlers.ClientRequest;
import com.example.SpringBootTask.Clients.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements IClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void createClient(ClientRequest clientRequest) {
        Client client = new Client();
        client.setName(clientRequest.getName());
        client.setLastName(clientRequest.getLastName());
        client.setMobile(clientRequest.getMobile());
        client.setEmail(clientRequest.getEmail());
        client.setAddress(clientRequest.getAddress());
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Long clientId, ClientRequest clientRequest) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));
        client.setName(clientRequest.getName());
        client.setLastName(clientRequest.getLastName());
        client.setMobile(clientRequest.getMobile());
        client.setEmail(clientRequest.getEmail());
        client.setAddress(clientRequest.getAddress());
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));
        clientRepository.delete(client);
    }
}
