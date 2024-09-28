package com.avshek.senior_care_connect.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "elderly_person_id", nullable = false)
    private ElderlyPerson elderlyPerson;

    private String type; // e.g., Medication, Appointment
    private String description;
    private LocalDateTime reminderTime;

    // Getters and Setters
    // (Include the getters and setters here)


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ElderlyPerson getElderlyPerson() {
        return elderlyPerson;
    }

    public void setElderlyPerson(ElderlyPerson elderlyPerson) {
        this.elderlyPerson = elderlyPerson;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }
}