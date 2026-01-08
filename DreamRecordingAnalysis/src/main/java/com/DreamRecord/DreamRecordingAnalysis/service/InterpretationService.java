package com.DreamRecord.DreamRecordingAnalysis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DreamRecord.DreamRecordingAnalysis.model.Interpretation;
import com.DreamRecord.DreamRecordingAnalysis.repository.InterpretationRepository;

@Service
public class InterpretationService{
	
	
	private final InterpretationRepository interpretationRepository;
	
	
	
	 public InterpretationService(InterpretationRepository interpretationRepository) {
		super();
		this.interpretationRepository = interpretationRepository;
	}

	 public Interpretation addInterpretation(Interpretation interpretation) {
	       
	        return interpretationRepository.save(interpretation);
	    }


	public Interpretation getInterpretationDetails(Long id) {
	        return interpretationRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Interpretation not found"));
	    }
	
	 public List<Interpretation> listInterpretationsForDream(Long recordId) {
	        return interpretationRepository.findByDreamRecord_RecordId(recordId);
	    }
}