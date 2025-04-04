package com.tcaputi.back.caccorporationserver.reminder.repository;

import com.tcaputi.back.caccorporationserver.reminder.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, UUID> {
    List<Reminder> findByClientId(UUID clientId);
}
