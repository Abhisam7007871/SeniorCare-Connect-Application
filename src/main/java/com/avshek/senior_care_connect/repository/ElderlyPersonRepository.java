package com.avshek.senior_care_connect.repository;

import com.avshek.senior_care_connect.model.ElderlyPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElderlyPersonRepository extends JpaRepository<ElderlyPerson, Long> {
}
