package com.example.CIMAInspection.service;

import com.example.CIMAInspection.entity.Inspection;

import java.util.List;

public interface InspectionService {

    List<Inspection> saveAllInspections(List<Inspection> inspections);

    List<Inspection> getInspectionsForClient(int clientId);

}
