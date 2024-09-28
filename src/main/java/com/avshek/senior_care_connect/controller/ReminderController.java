package com.avshek.senior_care_connect.controller;

import com.avshek.senior_care_connect.model.Reminder;
import com.avshek.senior_care_connect.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminders")
public class ReminderController {

    @Autowired
    private ReminderService service;

    @GetMapping
    public List<Reminder> getAllReminders() {
        return service.findByElderlyPersonId(null); // Adjust this as needed
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable Long id) {
        Reminder reminder = service.getReminderById(id);
        if (reminder != null) {
            return ResponseEntity.ok(reminder);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
        Reminder createdReminder = service.createReminder(reminder);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReminder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reminder> updateReminder(@PathVariable Long id, @RequestBody Reminder reminder) {
        Reminder updatedReminder = service.updateReminder(id, reminder);
        return ResponseEntity.ok(updatedReminder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReminder(@PathVariable Long id) {
        String response = service.deleteReminder(id);
        return ResponseEntity.ok(response);
    }
}
