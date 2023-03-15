package com.example.CIMAInspection.entity;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "User Id cannot be empty")
    @Column(name = "user_id")
    private int userId;
    @NotNull(message = "Client cannot be empty")
    @Column(name = "client_name")
    private String clientName;
    @NotNull(message = "Location cannot be empty")
    @Column(name = "location")
    private String location;
    @NotNull(message = "Date cannot be empty")
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "purchase_order_number")
    private String purchaseOrderNumber;
    @Column(name = "cima")
    private String cima;
    @Column(name = "exam_number")
    private String examNumber;
    @Column(name = "part")
    private String part;
    @Column(name = "report")
    private String report;
    @Column(name = "specification")
    private String specification;
    @Column(name = "procedure")
    private String procedure;
    @Column(name = "acceptance_criteria")
    private String acceptanceCriteria;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
