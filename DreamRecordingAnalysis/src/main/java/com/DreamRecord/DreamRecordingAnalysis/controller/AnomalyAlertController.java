package com.DreamRecord.DreamRecordingAnalysis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DreamRecord.DreamRecordingAnalysis.model.AnomalyAlert;
import com.DreamRecord.DreamRecordingAnalysis.service.AnomalyAlertService;

@RestController
@RequestMapping("/alerts")
public class AnomalyAlertController {

    @Autowired
    private AnomalyAlertService service;

    @PostMapping
    public AnomalyAlert raiseAlert(
                                   @RequestBody AnomalyAlert alert) {
        return service.raiseAlert( alert);
    }

    @GetMapping("/{id}")
    public AnomalyAlert getAlert(@PathVariable Long id) {
        return service.getAlertDetails(id);
    }

    @GetMapping("/participant/{participantId}")
    public List<AnomalyAlert> getAlertsByParticipant(@PathVariable Long participantId) {
        return service.listAlertsForParticipant(participantId);
    }

    @DeleteMapping("/{id}")
    public void deleteAlert(@PathVariable Long id) {
        service.clearAlert(id);
    }
}