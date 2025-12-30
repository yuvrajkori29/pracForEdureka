
package com.example.SmartEventManagement.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @ManyToOne
    private Event event;

    @ManyToMany
    private List<Attendee> attendees;
    
    

	public Registration() {
		super();
	}

	public Registration(Long registrationId, Event event, List<Attendee> attendees) {
		super();
		this.registrationId = registrationId;
		this.event = event;
		this.attendees = attendees;
	}

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Attendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<Attendee> attendees) {
		this.attendees = attendees;
	}

    // getters & setters
    
    
}
