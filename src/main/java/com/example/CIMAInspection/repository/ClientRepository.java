package com.example.CIMAInspection.repository;

import com.example.CIMAInspection.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findById(int id);
    Optional<List<Client>> findAllByUserId(int userId);
    Optional<Client> findByClientName(String clientName);

}
