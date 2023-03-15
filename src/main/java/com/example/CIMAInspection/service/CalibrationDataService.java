package com.example.CIMAInspection.service;


import com.example.CIMAInspection.entity.CalibrationData;

public interface CalibrationDataService {

    CalibrationData saveCalibrationData(CalibrationData calibrationData);

    CalibrationData getCalibrationData(int clientId);

}
