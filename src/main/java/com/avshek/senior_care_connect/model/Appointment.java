package com.avshek.senior_care_connect.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate appointmentDate;
    private String doctorName;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "elderly_person_id")
    private ElderlyPerson elderlyPerson;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ElderlyPerson getElderlyPerson() {
        return elderlyPerson;
    }

    public void setElderlyPerson(ElderlyPerson elderlyPerson) {
        this.elderlyPerson = elderlyPerson;
    }
}
