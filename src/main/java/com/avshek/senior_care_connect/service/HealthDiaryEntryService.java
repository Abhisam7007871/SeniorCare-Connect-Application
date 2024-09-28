package com.avshek.senior_care_connect.service;

import com.avshek.senior_care_connect.model.HealthDiaryEntry;
import com.avshek.senior_care_connect.repository.HealthDiaryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthDiaryEntryService {
    @Autowired
    private HealthDiaryEntryRepository repository;

    public List<HealthDiaryEntry> findByElderlyPersonId(Long elderlyPersonId) {
        return repository.findByElderlyPersonId(elderlyPersonId);
    }

    public HealthDiaryEntry CreateHealthDiary(HealthDiaryEntry entry) {
        return repository.save(entry);
    }

    public HealthDiaryEntry getHealthDiaryById(Long id){
        return repository.findById(id).orElse(null);
    }

    public HealthDiaryEntry updateHealthDiary(Long id, HealthDiaryEntry healthDiaryEntry){
        HealthDiaryEntry healthDiaryEntry1 = repository.findById(id).orElseThrow(()-> new RuntimeException("Health Diary Not Found"));
        healthDiaryEntry1.setDate(healthDiaryEntry.getDate());
        healthDiaryEntry1.setElderlyPerson(healthDiaryEntry.getElderlyPerson());
        healthDiaryEntry1.setNotes(healthDiaryEntry.getNotes());
        healthDiaryEntry1.setSymptoms(healthDiaryEntry.getSymptoms());

        return repository.save(healthDiaryEntry1);
    }

    public  String deleteHealthDiary(Long id){
        Optional<HealthDiaryEntry> healthDiaryEntry = repository.findById(id);
        if(healthDiaryEntry.isPresent()){
            HealthDiaryEntry healthDiaryEntry1 = healthDiaryEntry.get();
            repository.deleteById(id);

            return "Deleted Health Diary Entry with id: " + healthDiaryEntry1.getId();
        }else{
            return "Deleted Health Diary Entry with id: " + id + " not found";
        }
    }


}