package com.example.CIMAInspection.service.impl;

import com.example.CIMAInspection.entity.Inspection;
import com.example.CIMAInspection.repository.InspectionRepository;
import com.example.CIMAInspection.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InspectionsImpl implements InspectionService {

    @Autowired
    InspectionRepository inspectionRepository;

    @Override
    public List<Inspection> saveAllInspections(List<Inspection> inspections) {
        return inspectionRepository.saveAll(inspections);
    }

    @Override
    public List<Inspection> getInspectionsForClient(int clientId) {
        Optional<List<Inspection>> inspections = inspectionRepository.findAllByClientId(clientId);
        return inspections.orElse(null);
    }
}
