package com.example.SmartEventManagement.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartEventManagement.entity.Event;
import com.example.SmartEventManagement.repository.EventRepository;


@Service
public class EventService {
    
	@Autowired
    private final EventRepository repo;

    public EventService(EventRepository repo) {
        this.repo = repo;
    }

    public Event create(Event e) {
        return repo.save(e);
    }

    public Event get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Event update(Long id, Event e) {
        e.setEventId(id);
        return repo.save(e);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}


