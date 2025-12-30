
package com.example.SmartEventManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartEventManagement.entity.Attendee;
import com.example.SmartEventManagement.entity.Registration;
import com.example.SmartEventManagement.repository.AttendeeRepository;
import com.example.SmartEventManagement.repository.EventRepository;
import com.example.SmartEventManagement.repository.RegistrationRepository;


@Service
public class RegistrationService {

	@Autowired
    private final RegistrationRepository regRepo;
	@Autowired
    private final EventRepository eventRepo;
	@Autowired
    private final AttendeeRepository attendeeRepo;

    public RegistrationService(RegistrationRepository regRepo,
                               EventRepository eventRepo,
                               AttendeeRepository attendeeRepo) {
        this.regRepo = regRepo;
        this.eventRepo = eventRepo;
        this.attendeeRepo = attendeeRepo;
    }

    public Registration create(Long eventId) {
        Registration r = new Registration();
        r.setEvent(eventRepo.findById(eventId).orElse(null));
        return regRepo.save(r);
    }

    public Registration addAttendee(Long regId, Long attendeeId) {
        Registration r = regRepo.findById(regId).orElse(null);
        Attendee a = attendeeRepo.findById(attendeeId).orElse(null);

        r.getAttendees().add(a);
        return regRepo.save(r);
    }

    public Registration get(Long id) {
        return regRepo.findById(id).orElse(null);
    }
}
