package com.avshek.senior_care_connect.service;

import com.avshek.senior_care_connect.model.HealthDiaryEntry;
import com.avshek.senior_care_connect.model.Reminder;
import com.avshek.senior_care_connect.repository.HealthDiaryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthDiaryEntryService {
    @Autowired
    private HealthDiaryEntryRepository repository;

    // Fetches all health diary entries for a specific elderly person
    public List<HealthDiaryEntry> getAllElderlyPersonsId() {
        return repository.findAll();
    }

    // Creates a new health diary entry
    public HealthDiaryEntry createHealthDiary(HealthDiaryEntry entry) {
        // Optional: Validate the entry before saving
        if (entry.getElderlyPerson() == null) {
            throw new IllegalArgumentException("Elderly person must not be null");
        }
        return repository.save(entry);
    }

    // Fetches a health diary entry by ID
    public HealthDiaryEntry getHealthDiaryById(Long id) {
        // Optional: Consider throwing a custom exception here
        return repository.findById(id).orElse(null);
    }

    // Updates an existing health diary entry
    public HealthDiaryEntry updateHealthDiary(Long id, HealthDiaryEntry healthDiaryEntry) {
        HealthDiaryEntry existingEntry = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Health Diary Not Found"));

        // Update fields from the incoming entry
        existingEntry.setDate(healthDiaryEntry.getDate());
        existingEntry.setElderlyPerson(healthDiaryEntry.getElderlyPerson());
        existingEntry.setNotes(healthDiaryEntry.getNotes());
        existingEntry.setSymptoms(healthDiaryEntry.getSymptoms());

        return repository.save(existingEntry);
    }

    // Deletes a health diary entry by ID
    public String deleteHealthDiary(Long id) {
        // Check if the entry exists before trying to delete
        Optional<HealthDiaryEntry> healthDiaryEntry = repository.findById(id);
        if (healthDiaryEntry.isPresent()) {
            repository.deleteById(id);
            return "Deleted Health Diary Entry with id: " + id;
        } else {
            return "Health Diary Entry with id: " + id + " not found";
        }
    }
}
