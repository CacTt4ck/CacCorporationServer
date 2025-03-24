package com.tcaputi.back.caccorporationserver.reminder.service;

import com.tcaputi.back.caccorporationserver.client.entity.Client;
import com.tcaputi.back.caccorporationserver.reminder.entity.Reminder;
import com.tcaputi.back.caccorporationserver.client.repository.ClientRepository;
import com.tcaputi.back.caccorporationserver.reminder.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;
    private final ClientRepository clientRepository;

    public ReminderService(ReminderRepository reminderRepository, ClientRepository clientRepository) {
        this.reminderRepository = reminderRepository;
        this.clientRepository = clientRepository;
    }

    public Reminder createReminder(UUID clientId, String message, LocalDateTime reminderDate) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Reminder reminder = new Reminder(client, message, reminderDate);
        return reminderRepository.save(reminder);
    }

    public List<Reminder> getClientReminders(UUID clientId) {
        return reminderRepository.findByClientId(clientId);
    }
}
