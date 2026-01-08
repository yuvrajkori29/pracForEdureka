package com.DreamRecord.DreamRecordingAnalysis.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DreamRecord.DreamRecordingAnalysis.model.Participant;
import com.DreamRecord.DreamRecordingAnalysis.service.ParticipantService;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController{
	
	private final ParticipantService participantService;

	public ParticipantController(ParticipantService participantService) {
		super();
		this.participantService = participantService;
	}
	
	

	    @PostMapping
	    public Participant create(@RequestBody Participant p) {
	        return participantService.register(p);
	    }

	    @GetMapping("/{id}")
	    public Participant get(@PathVariable Long id) {
	        return participantService.getById(id);
	    }

	    @PutMapping("/{id}")
	    public Participant update(@PathVariable Long id, @RequestBody Participant p) {
	        return participantService.update(id, p);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	    	participantService.delete(id);
	    }
	
}