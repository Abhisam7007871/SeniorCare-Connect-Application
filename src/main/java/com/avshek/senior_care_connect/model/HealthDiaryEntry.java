package com.avshek.senior_care_connect.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class HealthDiaryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "elderly_person_id", nullable = false)
    private ElderlyPerson elderlyPerson;

    private LocalDate date;
    private String symptoms;
    private String notes;

    // Getters and Setters


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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
