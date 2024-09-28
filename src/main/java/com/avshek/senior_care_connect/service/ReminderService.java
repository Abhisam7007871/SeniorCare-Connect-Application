package com.avshek.senior_care_connect.service;

import com.avshek.senior_care_connect.model.Reminder;
import com.avshek.senior_care_connect.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderService {
    @Autowired
    private ReminderRepository remRepository;

    // Retrieve reminders for a specific elderly person
    public List<Reminder> findByElderlyPersonId(Long elderlyPersonId) {
        return remRepository.findByElderlyPersonId(elderlyPersonId);
    }

    // Get a reminder by ID
    public Reminder getReminderById(Long id) {
        return remRepository.findById(id).orElse(null);
    }

    // Create a new reminder
    public Reminder createReminder(Reminder reminder) {
        // You could add validation here (e.g., check if required fields are present)
        return remRepository.save(reminder);
    }

    // Update an existing reminder
    public Reminder updateReminder(Long id, Reminder updatedReminder) {
        Reminder existingReminder = remRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reminder Not Found with ID: " + id));

        // Update fields with the incoming details
        existingReminder.setType(updatedReminder.getType());
        existingReminder.setElderlyPerson(updatedReminder.getElderlyPerson());
        existingReminder.setReminderTime(updatedReminder.getReminderTime());
        existingReminder.setDescription(updatedReminder.getDescription());

        return remRepository.save(existingReminder);
    }

    // Delete a reminder by ID
    public String deleteReminder(Long id) {
        Optional<Reminder> reminderOptional = remRepository.findById(id);
        if (reminderOptional.isPresent()) {
            remRepository.deleteById(id);
            return "Deleted Reminder with ID: " + id;
        } else {
            return "Reminder with ID: " + id + " not found";
        }
    }
}
