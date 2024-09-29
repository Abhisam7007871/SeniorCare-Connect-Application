package com.avshek.senior_care_connect.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ElderlyPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private List<String> healthConditions;
    private List<String> medications;
    // Add a One-to-Many relationship for appointments
    @OneToMany(mappedBy = "elderlyPerson", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointment = new ArrayList<>();

    // Add method to add or remove appointment
     public void addAppointment(Appointment appointment) {
        // Add the appointment to the list
        this.appointment.add(appointment);

        // Set the reference of the elderly person in the appointment
        appointment.setElderlyPerson(this);
    }

    public void removeAppointment(Appointment appointment) {
        // Remove the appointment from the list
        this.appointment.remove(appointment);

        // Clear the reference to the elderly person in the appointment
        appointment.setElderlyPerson(null);
    }


    private String address;
    private String mobile;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String notes;  // Additional notes or information about the elderly person

    // Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHealthConditions() {
        return healthConditions;
    }

    public void setHealthConditions(List<String> healthConditions) {
        this.healthConditions = healthConditions;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public List<Appointment> getAppointments() {
        return appointment;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointment = appointments;
        for (Appointment appointment : appointments) {
            appointment.setElderlyPerson(this);  // Set ElderlyPerson reference for each appointment
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
