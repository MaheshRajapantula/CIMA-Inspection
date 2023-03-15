package com.example.CIMAInspection.service.impl;

import com.example.CIMAInspection.entity.PartData;
import com.example.CIMAInspection.repository.PartDataRepository;
import com.example.CIMAInspection.service.PartDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartDataServiceImpl implements PartDataService {

    @Autowired
    PartDataRepository partDataRepository;

    @Override
    public PartData savePartData(PartData partData) {
        return partDataRepository.save(partData);
    }

    @Override
    public PartData getPartDataByClientId(int clientId) {
        Optional<PartData> partData = partDataRepository.findByClientId(clientId);
        return partData.orElse(null);
    }

    @Override
    public boolean isPartDataExists(int clientId) {
        return false;
    }
}
