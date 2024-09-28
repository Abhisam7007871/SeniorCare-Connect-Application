package com.avshek.senior_care_connect.repository;

import com.avshek.senior_care_connect.model.HealthDiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthDiaryEntryRepository extends JpaRepository<HealthDiaryEntry, Long> {
    List<HealthDiaryEntry> findByElderlyPersonId(Long elderlyPersonId);
}