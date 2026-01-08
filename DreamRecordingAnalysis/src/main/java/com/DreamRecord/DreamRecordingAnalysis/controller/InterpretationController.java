package com.DreamRecord.DreamRecordingAnalysis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DreamRecord.DreamRecordingAnalysis.model.Interpretation;
import com.DreamRecord.DreamRecordingAnalysis.service.InterpretationService;

@RestController
@RequestMapping("/api/interpretations")
public class InterpretationController {
    
	private final InterpretationService interpretationService;
	
	

    public InterpretationController(InterpretationService interpretationService) {
		super();
		this.interpretationService = interpretationService;
	}
    
    @PostMapping
    public Interpretation addInterpretation(@RequestBody Interpretation interpretation) {
        return interpretationService.addInterpretation(interpretation);
    }
	@GetMapping("/{id}")
    public Interpretation getInterpretation(@PathVariable Long id) {
        return interpretationService.getInterpretationDetails(id);
    }

    @GetMapping("/dream/{recordId}")
    public List<Interpretation> getInterpretationsByDream(@PathVariable Long recordId) {
        return interpretationService.listInterpretationsForDream(recordId);
    }
}

