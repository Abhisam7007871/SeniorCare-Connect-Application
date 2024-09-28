package com.avshek.senior_care_connect.service;

import com.avshek.senior_care_connect.model.Reminder;
import com.avshek.senior_care_connect.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderService {
    @Autowired
    private ReminderRepository remRepository;

    public List<Reminder> findByElderlyPersonId(Long elderlyPersonId) {
        return remRepository.findByElderlyPersonId(elderlyPersonId);
    }

    public Reminder getReminderById(Long id){
        return remRepository.findById(id).orElse(null);
    }

    public Reminder createReminder(Reminder reminder) {
        return remRepository.save(reminder);
    }

    public Reminder updateReminder(Long id, Reminder reminder){
        Reminder reminder1 = remRepository.findById(id).orElseThrow(()-> new RuntimeException("Reminder Not Found"));
        reminder1.setType(reminder.getType());
        reminder1.setElderlyPerson(reminder.getElderlyPerson());
        reminder1.setReminderTime(reminder.getReminderTime());
        reminder1.setDescription(reminder.getDescription());
        return remRepository.save(reminder1);
    }

    public String deleteReminder(Long id){
        Optional<Reminder> deleteReminder = remRepository.findById(id);
        if(deleteReminder.isPresent()){
            Reminder reminder = deleteReminder.get();
            remRepository.deleteById(id);

            return "Deleted Reminder by ID: " + reminder.getId();

        }else{
            return "Deleted Reminder by ID: " + id + " not found";
        }
    }





}