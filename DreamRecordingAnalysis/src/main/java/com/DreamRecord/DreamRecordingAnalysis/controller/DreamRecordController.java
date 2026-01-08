package com.DreamRecord.DreamRecordingAnalysis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DreamRecord.DreamRecordingAnalysis.model.DreamRecord;
import com.DreamRecord.DreamRecordingAnalysis.service.DreamRecordService;

@RestController
@RequestMapping("/api/dreams")
public class DreamRecordController {


    private final DreamRecordService dreamRecordService;
    
    

    public DreamRecordController(DreamRecordService dreamRecordService) {
		super();
		this.dreamRecordService = dreamRecordService;
	}

	@PostMapping
    public DreamRecord addDream( @RequestBody DreamRecord record) {
        return dreamRecordService.addDreamRecord(record);
    }

    @GetMapping("/{id}")
    public DreamRecord getDream(@PathVariable Long id) {
        return dreamRecordService.getDreamDetails(id);
    }

    @GetMapping("/participant/{participantId}")
    public List<DreamRecord> getDreamsByParticipant(@PathVariable Long participantId) {
        return dreamRecordService.listDreamsForParticipant(participantId);
    }
}