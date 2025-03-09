package com.tcaputi.back.caccorporationserver.repository;

import com.tcaputi.back.caccorporationserver.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
    List<Invoice> findByClientId(UUID clientId);
}