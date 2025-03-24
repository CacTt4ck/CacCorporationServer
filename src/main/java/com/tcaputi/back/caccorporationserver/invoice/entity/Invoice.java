package com.tcaputi.back.caccorporationserver.invoice.entity;

import com.tcaputi.back.caccorporationserver.client.entity.Client;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String invoiceNumber;
    private Long amount;
    private boolean paid;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;

    public Invoice(Client client, String invoiceNumber, Long amount, LocalDateTime dueDate) {
        this.client = client;
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paid = false;
        this.createdAt = LocalDateTime.now();
    }

}
