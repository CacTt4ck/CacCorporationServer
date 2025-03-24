package com.tcaputi.back.caccorporationserver.client.repository;

import com.tcaputi.back.caccorporationserver.client.entity.ClientInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientInteractionRepository extends JpaRepository<ClientInteraction, UUID> {
    List<ClientInteraction> findByClientId(UUID clientId);
}