package com.example.CIMAInspection.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Inspection {
    private int clientId;
    private String tml;
    private float north;
    private float south;
    private float east;
    private float west;
    private float top;
    private float bottom;
    private float inside;
    private float outside;
    private float nominal;
    private float minThick;
}
