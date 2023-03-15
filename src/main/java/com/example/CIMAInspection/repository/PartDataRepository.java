package com.example.CIMAInspection.repository;

import com.example.CIMAInspection.entity.PartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartDataRepository extends JpaRepository<PartData, Long> {
    Optional<PartData> findByClientId(int clientId);
}
