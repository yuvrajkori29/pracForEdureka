package com.example.SmartEventManagement.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String title;
    private String location;
    private LocalDate date;
    
    
    
    
	public Event() {
		super();
	}
	
	
	public Event(Long eventId, String title, String location, LocalDate date) {
		super();
		this.eventId = eventId;
		this.title = title;
		this.location = location;
		this.date = date;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

    // getters & setters
    
}
