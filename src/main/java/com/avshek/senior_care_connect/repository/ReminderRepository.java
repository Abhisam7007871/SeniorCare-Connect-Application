package com.avshek.senior_care_connect.repository;


import com.avshek.senior_care_connect.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByElderlyPersonId(Long elderlyPersonId);
}