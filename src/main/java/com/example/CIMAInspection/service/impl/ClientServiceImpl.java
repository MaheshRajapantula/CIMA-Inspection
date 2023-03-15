package com.example.CIMAInspection.service.impl;

import com.example.CIMAInspection.entity.CalibrationData;
import com.example.CIMAInspection.entity.Client;
import com.example.CIMAInspection.entity.Inspection;
import com.example.CIMAInspection.entity.PartData;
import com.example.CIMAInspection.repository.CalibrationDataRepository;
import com.example.CIMAInspection.repository.ClientRepository;
import com.example.CIMAInspection.repository.InspectionRepository;
import com.example.CIMAInspection.repository.PartDataRepository;
import com.example.CIMAInspection.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PartDataRepository partDataRepository;
    @Autowired
    InspectionRepository inspectionRepository;
    @Autowired
    CalibrationDataRepository calibrationDataRepository;


    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public com.example.CIMAInspection.model.Client getClient(String clientName, int userId) {
        com.example.CIMAInspection.model.Client client = new com.example.CIMAInspection.model.Client();
        Optional<Client> clientData = clientRepository.findByClientName(clientName);
        if(clientData.isEmpty()) {
            return null;
        }
        clientData.ifPresent(client::setClientData);
        Optional<PartData> partData = partDataRepository.findByClientId(clientData.get().getId());
        partData.ifPresent(client::setPartData);
        Optional<CalibrationData> calibrationData = calibrationDataRepository.findByClientId(clientData.get().getId());
        calibrationData.ifPresent(client::setCalibrationData);
        Optional<List<Inspection>> inspections = inspectionRepository.findAllByClientId(clientData.get().getId());
        inspections.ifPresent(client::setInspectionList);

        return client;
    }

    @Override
    public Client getClientDataByClientName(String clientName) {
        Optional<Client> clientData = clientRepository.findByClientName(clientName);
        return clientData.orElse(null);
    }

    @Override
    public List<Client> getClientsByUserId(int userId) {
        Optional<List<Client>> clients = clientRepository.findAllByUserId(userId);
        return clients.orElse(null);
    }

    @Override
    public boolean isClientExist(int clientId) {
        return clientRepository.existsById((long) clientId);
    }

    @Override
    public Client getClientDataByClientId(int clientId) {
        Optional<Client> clientData = clientRepository.findById(clientId);
        return clientData.orElse(null);
    }

}
