package com.example.CIMAInspection.repository;

import com.example.CIMAInspection.entity.CalibrationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalibrationDataRepository extends JpaRepository<CalibrationData, Long> {
    Optional<CalibrationData> findByClientId(int clientId);

}
