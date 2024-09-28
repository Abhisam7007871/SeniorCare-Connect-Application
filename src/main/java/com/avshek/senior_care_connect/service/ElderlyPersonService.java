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

    public List<ElderlyPerson> getAllElderlyPerson(){
        return epRepository.findAll();
    }

    public ElderlyPerson getElderlyPersonById(Long id){
        return epRepository.findById(id).orElse(null);
    }

    public ElderlyPerson createElderlyPerson(ElderlyPerson elderlyPerson){
        return epRepository.save(elderlyPerson);
    }

    public ElderlyPerson updateElderlyPerson(Long id, ElderlyPerson elderlyPerson){
        ElderlyPerson elderlyPerson1 = epRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        elderlyPerson1.setAddress(elderlyPerson.getAddress());
        elderlyPerson1.setAppointments(elderlyPerson.getAppointments());
        elderlyPerson1.setEmergencyContactName(elderlyPerson.getEmergencyContactName());
        elderlyPerson1.setEmergencyContactNumber(elderlyPerson.getEmergencyContactNumber());
        elderlyPerson1.setHealthConditions(elderlyPerson.getHealthConditions());
        elderlyPerson1.setMedications(elderlyPerson.getMedications());
        elderlyPerson1.setMobile(elderlyPerson.getMobile());
        elderlyPerson1.setName(elderlyPerson.getName());
        elderlyPerson1.setNotes(elderlyPerson.getNotes());

        return epRepository.save(elderlyPerson1);
    }

    public String deleteElderlyPerson(Long id){
        Optional<ElderlyPerson> elderlyPersonDel = epRepository.findById(id);
        if(elderlyPersonDel.isPresent()){
            ElderlyPerson elderlyPerson = elderlyPersonDel.get();
            epRepository.deleteById(id);

            return "Deleted details with id: " + elderlyPerson.getId();
        }else{
            return "Deleted details with id: " + id + " not found";
        }
    }

}
