package com.example.SmartEventManagement.controller;

import org.springframework.web.bind.annotation.*;

import com.example.SmartEventManagement.entity.Event;
import com.example.SmartEventManagement.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event e) {
        return service.create(e);
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        service.delete(id);
    }
}