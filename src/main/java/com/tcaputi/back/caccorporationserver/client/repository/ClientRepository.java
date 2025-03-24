package com.tcaputi.back.caccorporationserver.client.repository;

import com.tcaputi.back.caccorporationserver.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByEmail(String email);
    List<Client> findByNameContainingIgnoreCase(String name);

}
