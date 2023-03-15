package com.example.CIMAInspection.controller;

import com.example.CIMAInspection.entity.CalibrationData;
import com.example.CIMAInspection.entity.Client;
import com.example.CIMAInspection.model.ClientData;
import com.example.CIMAInspection.model.ErrorResponse;
import com.example.CIMAInspection.model.Inspection;
import com.example.CIMAInspection.model.PartData;
import com.example.CIMAInspection.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private UserService userService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private PartDataService partDataService;
    @Autowired
    private CalibrationDataService calibrationDataService;
    @Autowired
    private InspectionService inspectionService;

    @GetMapping("/clientData/{clientId}")
    public ResponseEntity<?> getClientByClientId(@PathVariable int clientId) {
        if(!clientService.isClientExist(clientId)) {
            return new ResponseEntity<>("Client doesn't exist", HttpStatus.BAD_REQUEST);
        }

        Client client = clientService.getClientDataByClientId(clientId);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping(value = {"/clientData"})
    public ResponseEntity<?> saveClientData(@RequestBody ClientData clientData) {
        if(!userService.isUserExists(clientData.getUserId())) {
            return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);
        }

        Client client = new Client();
        client.setUserId(clientData.getUserId());
        client.setClientName(clientData.getClient());
        client.setLocation(clientData.getLocation());
        client.setDate(clientData.getDate());
        client.setPurchaseOrderNumber(clientData.getPurchaseOrderNumber());
        client.setCima(clientData.getCima());
        client.setExamNumber(clientData.getExamNumber());
        client.setPart(clientData.getPart());
        client.setReport(clientData.getReport());
        client.setSpecification(clientData.getSpecification());
        client.setProcedure(clientData.getProcedure());
        client.setAcceptanceCriteria(clientData.getAcceptanceCriteria());

        Client savedClient = clientService.saveClient(client);

        return new ResponseEntity<>(savedClient, HttpStatus.OK);
    }

    @PutMapping("/clientData/{clientId}")
    public ResponseEntity<?> updateClientData(@RequestBody ClientData clientData, @PathVariable int clientId) {
        if(!clientService.isClientExist(clientId)) {
            return new ResponseEntity<>("Client doesn't exist", HttpStatus.BAD_REQUEST);
        }

        Client client = new Client();
        client.setId(clientId);
        client.setUserId(clientData.getUserId());
        client.setClientName(clientData.getClient());
        client.setLocation(clientData.getLocation());
        client.setDate(clientData.getDate());
        client.setPurchaseOrderNumber(clientData.getPurchaseOrderNumber());
        client.setCima(clientData.getCima());
        client.setExamNumber(clientData.getExamNumber());
        client.setPart(clientData.getPart());
        client.setReport(clientData.getReport());
        client.setSpecification(clientData.getSpecification());
        client.setProcedure(clientData.getProcedure());
        client.setAcceptanceCriteria(clientData.getAcceptanceCriteria());

        Client savedClient = clientService.saveClient(client);

        return new ResponseEntity<>(savedClient, HttpStatus.OK);
    }

    @PostMapping("/partData")
    public ResponseEntity<?> savePartData(@RequestBody PartData partData) {
        if(!clientService.isClientExist(partData.getClientId())) {
            return new ResponseEntity<>("Client doesn't exist", HttpStatus.BAD_REQUEST);
        }

        com.example.CIMAInspection.entity.PartData existingPartData = partDataService.getPartDataByClientId(partData.getClientId());
        com.example.CIMAInspection.entity.PartData partDataEntity = new com.example.CIMAInspection.entity.PartData();

        if(existingPartData != null) {
            partDataEntity.setId(existingPartData.getId());
        }

        partDataEntity.setClientId(partData.getClientId());
        partDataEntity.setPartId(partData.getPartId());
        partDataEntity.setSurface(partData.getSurface());
        partDataEntity.setPnid(partData.getPnid());
        partDataEntity.setDwg(partData.getDwg());
        partDataEntity.setTemp(partData.getTemp());
        partDataEntity.setMtl(partData.getMtl());

        com.example.CIMAInspection.entity.PartData savedClientPartData = partDataService.savePartData(partDataEntity);

        return new ResponseEntity<>(savedClientPartData, HttpStatus.OK);
    }

    @GetMapping("/partData/{clientId}")
    public ResponseEntity<?> getPartDataByClientId(@PathVariable int clientId) {
        if(!clientService.isClientExist(clientId)) {
            return new ResponseEntity<>("Client doesn't exist", HttpStatus.BAD_REQUEST);
        }

        com.example.CIMAInspection.entity.PartData partData = partDataService.getPartDataByClientId(clientId);
        if(partData == null) {
            return new ResponseEntity<>(new ErrorResponse("CLI-003", "Part Data for this client doesn't exist!"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(partData, HttpStatus.OK);
    }

    @PostMapping("/calibrationData")
    public ResponseEntity<?> saveCalibrationData(@RequestBody com.example.CIMAInspection.model.CalibrationData calibrationData) {
        if(!clientService.isClientExist(calibrationData.getClientId())) {
            return new ResponseEntity<>("Client doesn't exist", HttpStatus.BAD_REQUEST);
        }

        com.example.CIMAInspection.entity.CalibrationData existingCalibrationData = calibrationDataService.getCalibrationData(calibrationData.getClientId());
        com.example.CIMAInspection.entity.CalibrationData CalibrationDataEntity = new com.example.CIMAInspection.entity.CalibrationData();

        if(existingCalibrationData != null) {
            CalibrationDataEntity.setId(existingCalibrationData.getId());
        }

        CalibrationDataEntity.setClientId(calibrationData.getClientId());
        CalibrationDataEntity.setMaterial(calibrationData.getMaterial());
        CalibrationDataEntity.setSurface(calibrationData.getSurface());
        CalibrationDataEntity.setUeModel(calibrationData.getUeModel());
        CalibrationDataEntity.setUeSerial(calibrationData.getUeSerial());
        CalibrationDataEntity.setProbeModel(calibrationData.getProbeModel());
        CalibrationDataEntity.setProbeSerial(calibrationData.getProbeSerial());
        CalibrationDataEntity.setVelocity(calibrationData.getVelocity());
        CalibrationDataEntity.setDelay(calibrationData.getDelay());
        CalibrationDataEntity.setFrequency(calibrationData.getFrequency());

        com.example.CIMAInspection.entity.CalibrationData savedClientCalibrationData = calibrationDataService.saveCalibrationData(CalibrationDataEntity);

        return new ResponseEntity<>(savedClientCalibrationData, HttpStatus.OK);
    }

    @GetMapping("/calibrationData/{clientId}")
    public ResponseEntity<?> getCalibrationDataByClientId(@PathVariable int clientId) {
        if(!clientService.isClientExist(clientId)) {
            return new ResponseEntity<>("Client doesn't exist", HttpStatus.BAD_REQUEST);
        }

        CalibrationData calibrationData = calibrationDataService.getCalibrationData(clientId);
        if(calibrationData == null) {
            return new ResponseEntity<>(new ErrorResponse("CLI-003", "Part Data for this client doesn't exist!"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(calibrationData, HttpStatus.OK);
    }

    @PostMapping("/inspections")
    public ResponseEntity<?> saveInspections(@RequestBody List<Inspection> inspections) {
        List<com.example.CIMAInspection.entity.Inspection> inspectionList = new ArrayList<>();
        for (Inspection inspection : inspections) {
            com.example.CIMAInspection.entity.Inspection inspectionEntity = new com.example.CIMAInspection.entity.Inspection();
            inspectionEntity.setClientId(inspection.getClientId());
            inspectionEntity.setTml(inspection.getTml());
            inspectionEntity.setNorth(inspection.getNorth());
            inspectionEntity.setSouth(inspection.getSouth());
            inspectionEntity.setEast(inspection.getEast());
            inspectionEntity.setWest(inspection.getWest());
            inspectionEntity.setTop(inspection.getTop());
            inspectionEntity.setBottom(inspection.getBottom());
            inspectionEntity.setInside(inspection.getInside());
            inspectionEntity.setOutside(inspection.getOutside());
            inspectionEntity.setNominal(inspection.getNominal());
            inspectionEntity.setMinThick(inspection.getMinThick());
            inspectionList.add(inspectionEntity);
        }

        List<com.example.CIMAInspection.entity.Inspection> savedInspections = inspectionService.saveAllInspections(inspectionList);
        return new ResponseEntity<>(savedInspections, HttpStatus.OK);
    }

    @GetMapping("/inspections/{clientId}")
    public ResponseEntity<?> getInspections(@PathVariable int clientId) {
        if(!clientService.isClientExist(clientId)) {
            return new ResponseEntity<>("Client doesn't exist", HttpStatus.BAD_REQUEST);
        }

        List<com.example.CIMAInspection.entity.Inspection> inspections = inspectionService.getInspectionsForClient(clientId);
        if(inspections == null) {
            return new ResponseEntity<>(new ErrorResponse("CLI-004", "Part Data for this client doesn't exist!"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(inspections, HttpStatus.OK);
    }

    @GetMapping("/search/{userId}/{clientName}")
    public ResponseEntity<?> getClient(@PathVariable int userId, @PathVariable String clientName) {
        Client clientData = clientService.getClientDataByClientName(clientName);
        if(clientData == null) {
            return new ResponseEntity<>("Client doesn't exist", HttpStatus.BAD_REQUEST);
        }

        com.example.CIMAInspection.model.Client client = clientService.getClient(clientName, clientData.getUserId());

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}
