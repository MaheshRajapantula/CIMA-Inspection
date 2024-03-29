package com.example.CIMAInspection.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientData {

    private int userId;
    private String client;
    private String location;
    private LocalDate date;
    private String purchaseOrderNumber;
    private String cima;
    private String examNumber;
    private String part;
    private String report;
    private String specification;
    private String procedure;
    private String acceptanceCriteria;

}
