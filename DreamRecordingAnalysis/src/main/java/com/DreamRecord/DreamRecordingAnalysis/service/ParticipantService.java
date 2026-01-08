package com.DreamRecord.DreamRecordingAnalysis.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.DreamRecord.DreamRecordingAnalysis.model.Participant;
import com.DreamRecord.DreamRecordingAnalysis.repository.ParticipantRepository;



@Service
public class ParticipantService{
	
	public final ParticipantRepository participantRepository;

	public ParticipantService(ParticipantRepository participantRepository) {
		super();
		this.participantRepository = participantRepository;
	}
	
	public Participant register(Participant p) {
        return participantRepository.save(p);
    }

    @Cacheable(value = "participants", key = "#id")
    public Participant getById(Long id) {
        return participantRepository.findById(id).orElseThrow();
    }

    @CachePut(value = "participants", key = "#id")
    public Participant update(Long id, Participant p) {
        p.setParticipantId(id);
        return participantRepository.save(p);
    }

    @CacheEvict(value = "participants", key = "#id")
    public void delete(Long id) {
    	participantRepository.deleteById(id);
    }
}
