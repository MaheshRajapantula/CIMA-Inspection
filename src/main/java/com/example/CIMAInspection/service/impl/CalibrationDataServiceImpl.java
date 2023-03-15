package com.example.CIMAInspection.service.impl;

import com.example.CIMAInspection.entity.CalibrationData;
import com.example.CIMAInspection.repository.CalibrationDataRepository;
import com.example.CIMAInspection.service.CalibrationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalibrationDataServiceImpl implements CalibrationDataService {

    @Autowired
    CalibrationDataRepository calibrationDataRepository;

    @Override
    public CalibrationData saveCalibrationData(CalibrationData calibrationData) {
        return calibrationDataRepository.save(calibrationData);
    }

    @Override
    public CalibrationData getCalibrationData(int clientId) {
        Optional<CalibrationData> calibrationData = calibrationDataRepository.findByClientId(clientId);
        return calibrationData.orElse(null);
    }
}
