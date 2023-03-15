package com.example.CIMAInspection.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "part_data", uniqueConstraints = {@UniqueConstraint(columnNames = {"clientId"})})
public class PartData {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(name = "clientId", nullable = false)
    private int clientId;
    @Column(name = "partId", nullable = false)
    private String partId;
    @Column(name = "surface")
    private String surface;
    @Column(name = "pnid")
    private String pnid;
    @Column(name = "dwg")
    private String dwg;
    @Column(name = "temp")
    private String temp;
    @Column(name = "mtl")
    private String mtl;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
