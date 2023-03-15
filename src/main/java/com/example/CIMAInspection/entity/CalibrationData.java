package com.example.CIMAInspection.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "calibration_data", uniqueConstraints = {@UniqueConstraint(columnNames = {"clientId"})})
public class CalibrationData {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(name = "clientId", nullable = false)
    private int clientId;
    @Column(name = "material")
    private String material;
    @Column(name = "surface")
    private String surface;
    @Column(name = "ueModel")
    private String ueModel;
    @Column(name = "ueSerial")
    private String ueSerial;
    @Column(name = "probeModel")
    private String probeModel;
    @Column(name = "probeSerial")
    private String probeSerial;
    @Column(name = "velocity")
    private String velocity;
    @Column(name = "delay")
    private String delay;
    @Column(name = "frequency")
    private String frequency;
}
