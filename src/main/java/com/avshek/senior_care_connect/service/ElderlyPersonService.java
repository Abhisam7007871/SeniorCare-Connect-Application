package com.avshek.senior_care_connect.service;

import com.avshek.senior_care_connect.model.ElderlyPerson;
import com.avshek.senior_care_connect.repository.ElderlyPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElderlyPersonService {

    @Autowired
    private ElderlyPersonRepository epRepository;

    // Retrieve all elderly persons
    public List<ElderlyPerson> getAllElderlyPersons() {
        return epRepository.findAll();
    }

    // Get an elderly person by ID
    public ElderlyPerson getElderlyPersonById(Long id) {
        return epRepository.findById(id).orElse(null);
    }

    // Create a new elderly person profile
    public ElderlyPerson createElderlyPerson(ElderlyPerson elderlyPerson) {
        // You could add more validation here (e.g., checking if mandatory fields are filled)
        return epRepository.save(elderlyPerson);
    }

    // Update an existing elderly person's profile
    public ElderlyPerson updateElderlyPerson(Long id, ElderlyPerson elderlyPerson){
        ElderlyPerson existingPerson = epRepository.findById(id).orElseThrow(()-> new RuntimeException("ElderlyPerson Not Found"));

        // Update the necessary fields
        existingPerson.setAddress(elderlyPerson.getAddress());
        existingPerson.setAppointments(elderlyPerson.getAppointments());
        existingPerson.setEmergencyContactName(elderlyPerson.getEmergencyContactName());
        existingPerson.setEmergencyContactNumber(elderlyPerson.getEmergencyContactNumber());
        existingPerson.setHealthConditions(elderlyPerson.getHealthConditions());
        existingPerson.setMedications(elderlyPerson.getMedications());
        existingPerson.setMobile(elderlyPerson.getMobile());
        existingPerson.setName(elderlyPerson.getName());
        existingPerson.setNotes(elderlyPerson.getNotes());

        return epRepository.save(existingPerson);  // Save the updated entity
    }


    // Delete an elderly person's profile
    public String deleteElderlyPerson(Long id) {
        Optional<ElderlyPerson> elderlyPersonOptional = epRepository.findById(id);
        if (elderlyPersonOptional.isPresent()) {
            epRepository.deleteById(id);
            return "Deleted elderly person with ID: " + id;
        } else {
            return "Elderly person with ID: " + id + " not found";
        }
    }
}
