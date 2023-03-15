package com.example.CIMAInspection.model;

import com.example.CIMAInspection.entity.CalibrationData;
import com.example.CIMAInspection.entity.Inspection;
import com.example.CIMAInspection.entity.PartData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private com.example.CIMAInspection.entity.Client clientData;

    private PartData partData;

    private CalibrationData calibrationData;

    private List<Inspection> inspectionList;

}
