
package com.example.SmartEventManagement.entity;

import jakarta.persistence.*;

@Entity
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendeeId;

    private String name;
    private String email;
    
    
	public Attendee() {
		super();
	}
	public Attendee(Long attendeeId, String name, String email) {
		super();
		this.attendeeId = attendeeId;
		this.name = name;
		this.email = email;
	}
	public Long getAttendeeId() {
		return attendeeId;
	}
	public void setAttendeeId(Long attendeeId) {
		this.attendeeId = attendeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    // getters & setters
    
}


