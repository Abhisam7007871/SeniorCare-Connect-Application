package com.avshek.senior_care_connect.controller;

import com.avshek.senior_care_connect.model.Appointment;
import com.avshek.senior_care_connect.model.ElderlyPerson;
import com.avshek.senior_care_connect.repository.ElderlyPersonRepository;
import com.avshek.senior_care_connect.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ElderlyPersonRepository elderlyPersonRepository;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping("/appointments")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        ElderlyPerson elderlyPerson = elderlyPersonRepository.findById(appointment.getElderlyPerson().getId())
                .orElseThrow(() -> new RuntimeException("ElderlyPerson not found"));

        // Add appointment to elderly person
        elderlyPerson.addAppointment(appointment);

        // Save the elderly person (which also saves the appointment due to cascade)
        elderlyPersonRepository.save(elderlyPerson);

        return ResponseEntity.ok(appointment);
    }


    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(id, appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
