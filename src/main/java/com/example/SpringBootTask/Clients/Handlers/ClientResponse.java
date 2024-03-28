package com.example.SpringBootTask.Clients.Handlers;

import com.example.SpringBootTask.Clients.Entity.Client;

import java.util.List;

public class ClientResponse {
    private List<Client> clients;

    public ClientResponse() {
    }

    public ClientResponse(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
