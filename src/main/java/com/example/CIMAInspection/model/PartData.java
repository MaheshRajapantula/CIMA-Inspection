package com.example.CIMAInspection.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PartData {

    private int clientId;
    private String partId;
    private String surface;
    private String pnid;
    private String dwg;
    private String temp;
    private String mtl;
}
