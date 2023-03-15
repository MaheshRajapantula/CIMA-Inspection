package com.example.CIMAInspection.repository;

import com.example.CIMAInspection.entity.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InspectionRepository extends JpaRepository<Inspection, Long> {
    Optional<List<Inspection>> findAllByClientId(int clientId);

}
