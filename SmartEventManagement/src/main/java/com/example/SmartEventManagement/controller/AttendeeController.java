package com.example.SmartEventManagement.controller;

import org.springframework.web.bind.annotation.*;

import com.example.SmartEventManagement.entity.Attendee;
import com.example.SmartEventManagement.service.AttendeeService;


@RestController
@RequestMapping("/attendees")
public class AttendeeController {

    private final AttendeeService service;

    public AttendeeController(AttendeeService service) {
        this.service = service;
    }

    @PostMapping
    public Attendee registerAttendee(@RequestBody Attendee a) {
        return service.register(a);
    }

    @GetMapping("/{id}")
    public Attendee getAttendee(@PathVariable Long id) {
        return service.get(id);
    }
}