package com.example.SpringBootTask.Clients.Serviecs;


import com.example.SpringBootTask.Clients.Entity.Client;
import com.example.SpringBootTask.Clients.Handlers.ClientRequest;

import java.util.List;

public interface IClientService {
    public List<Client> getAllClients();
    public void createClient(ClientRequest clientRequest);
    public void updateClient(Long clientId, ClientRequest clientRequest);
    public void deleteClient(Long clientId);
}
