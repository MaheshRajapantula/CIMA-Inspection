package com.example.CIMAInspection.service;

import com.example.CIMAInspection.entity.Client;
import com.example.CIMAInspection.model.Search;

import java.util.List;

public interface ClientService {

    Client saveClient(Client client);

    com.example.CIMAInspection.model.Client getClient(Search search, int userId);

    Client getClientDataByClientName(String clientName);

    Client getClientDataBySearchDetailsAndUserId(Search search, int userId);

    List<Client> getClientsByUserId(int userId);

    boolean isClientExist(int clientId);

    Client getClientDataByClientId(int clientId);

}
