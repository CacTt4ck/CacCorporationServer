package com.tcaputi.back.caccorporationserver.client.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class ClientInteraction {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String type; // "QUOTE", "INVOICE", "REMINDER"
    private String description;
    private LocalDateTime timestamp;

    public ClientInteraction(Client client, String type, String description) {
        this.client = client;
        this.type = type;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

}
