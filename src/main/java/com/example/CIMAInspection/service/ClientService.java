package com.example.CIMAInspection.service;

import com.example.CIMAInspection.entity.Client;
import java.util.List;

public interface ClientService {

    Client saveClient(Client client);

    com.example.CIMAInspection.model.Client getClient(String client, int userId);

    Client getClientDataByClientName(String clientName);

    List<Client> getClientsByUserId(int userId);

    boolean isClientExist(int clientId);

    Client getClientDataByClientId(int clientId);

}
