package com.example.CIMAInspection.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inspections")
public class Inspection {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(name = "clientId", nullable = false)
    private int clientId;
    @Column(name = "tml", nullable = false)
    private String tml;
    @Column(name = "north")
    private float north;
    @Column(name = "south")
    private float south;
    @Column(name = "east")
    private float east;
    @Column(name = "west")
    private float west;
    @Column(name = "top")
    private float top;
    @Column(name = "bottom")
    private float bottom;
    @Column(name = "inside")
    private float inside;
    @Column(name = "outside")
    private float outside;
    @Column(name = "nominal")
    private float nominal;
    @Column(name = "minThick")
    private float minThick;

}
