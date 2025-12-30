
package com.example.SmartEventManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartEventManagement.entity.Attendee;
import com.example.SmartEventManagement.repository.AttendeeRepository;

@Service
public class AttendeeService {

	@Autowired
    private final AttendeeRepository repo;

    public AttendeeService(AttendeeRepository repo) {
        this.repo = repo;
    }

    
    
    public Attendee register(Attendee a) {
        return repo.save(a);
    }

    public Attendee get(Long id) {
        return repo.findById(id).orElse(null);
    }
}

