package com.avshek.senior_care_connect.controller;

import com.avshek.senior_care_connect.model.ElderlyPerson;
import com.avshek.senior_care_connect.service.ElderlyPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elderly")
public class ElderlyPersonController {

    @Autowired
    private ElderlyPersonService service;

    @GetMapping
    public List<ElderlyPerson> getAllElderlyPersons() {
        return service.getAllElderlyPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElderlyPerson> getElderlyPersonById(@PathVariable Long id){
        ElderlyPerson elderlyPerson =  service.getElderlyPersonById(id);
        if(elderlyPerson != null){
            return ResponseEntity.ok(elderlyPerson);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<ElderlyPerson> createElderlyPerson(@RequestBody ElderlyPerson elderlyPerson){
        ElderlyPerson createPerson =  service.createElderlyPerson(elderlyPerson);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElderlyPerson> updateElderlyPerson(@PathVariable Long id, @RequestBody ElderlyPerson elderlyPerson){
        ElderlyPerson updatePerson = service.updateElderlyPerson(id, elderlyPerson);
        return ResponseEntity.ok(updatePerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteElderlyPerson(@PathVariable Long id){
        String response = service.deleteElderlyPerson(id);
        return ResponseEntity.ok(response);
    }





}
