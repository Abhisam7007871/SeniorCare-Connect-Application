package com.avshek.senior_care_connect.controller;

import com.avshek.senior_care_connect.model.HealthDiaryEntry;
import com.avshek.senior_care_connect.service.HealthDiaryEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health-diaries")
public class HealthDiaryController {

    @Autowired
    private HealthDiaryEntryService service;

    @GetMapping
    public List<HealthDiaryEntry> getAllHealthDiaries() {
        return service.getAllElderlyPersonsId(); // Adjust this as needed
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthDiaryEntry> getHealthDiaryById(@PathVariable Long id) {
        HealthDiaryEntry diaryEntry = service.getHealthDiaryById(id);
        if (diaryEntry != null) {
            return ResponseEntity.ok(diaryEntry);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<HealthDiaryEntry> createHealthDiary(@RequestBody HealthDiaryEntry diaryEntry) {
        HealthDiaryEntry createdEntry = service.createHealthDiary(diaryEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthDiaryEntry> updateHealthDiary(@PathVariable Long id, @RequestBody HealthDiaryEntry diaryEntry) {
        HealthDiaryEntry updatedEntry = service.updateHealthDiary(id, diaryEntry);
        return ResponseEntity.ok(updatedEntry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHealthDiary(@PathVariable Long id) {
        String response = service.deleteHealthDiary(id);
        return ResponseEntity.ok(response);
    }
}
