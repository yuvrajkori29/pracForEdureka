package com.example.SmartEventManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartEventManagement.entity.Registration;
import com.example.SmartEventManagement.service.RegistrationService;



@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @PostMapping
    public Registration createRegistration(@RequestParam Long eventId) {
        return service.create(eventId);
    }

    @PutMapping("/{id}/addAttendee/{attendeeId}")
    public Registration addAttendeeToEvent(
            @PathVariable Long id,
            @PathVariable Long attendeeId) {

        return service.addAttendee(id, attendeeId);
    }

    @GetMapping("/{id}")
    public Registration getRegistration(@PathVariable Long id) {
        return service.get(id);
    }
}