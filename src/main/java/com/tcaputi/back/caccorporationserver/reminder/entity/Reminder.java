package com.tcaputi.back.caccorporationserver.reminder.entity;

import com.tcaputi.back.caccorporationserver.client.entity.Client;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Reminder {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String message;
    private LocalDateTime reminderDate;
    private boolean sent;

    public Reminder(Client client, String message, LocalDateTime reminderDate) {
        this.client = client;
        this.message = message;
        this.reminderDate = reminderDate;
        this.sent = false;
    }
}
