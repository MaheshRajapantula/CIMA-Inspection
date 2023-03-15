package com.example.CIMAInspection.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CalibrationData {
    private int clientId;
    private String material;
    private String surface;
    private String ueModel;
    private String ueSerial;
    private String probeModel;
    private String probeSerial;
    private String velocity;
    private String delay;
    private String frequency;
}
