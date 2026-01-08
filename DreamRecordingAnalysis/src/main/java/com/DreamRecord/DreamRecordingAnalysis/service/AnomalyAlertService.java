package com.DreamRecord.DreamRecordingAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DreamRecord.DreamRecordingAnalysis.model.AnomalyAlert;
import com.DreamRecord.DreamRecordingAnalysis.repository.AnomalyAlertRepository;

@Service
public class AnomalyAlertService {

    @Autowired
    private AnomalyAlertRepository alertRepo;



    public AnomalyAlert raiseAlert(AnomalyAlert alert) {
      
        return alertRepo.save(alert);
    }

    public AnomalyAlert getAlertDetails(Long id) {
        return alertRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    public List<AnomalyAlert> listAlertsForParticipant(Long participantId) {
        return alertRepo.findByParticipant_ParticipantId(participantId);
    }

    public void clearAlert(Long id) {
        alertRepo.deleteById(id);
    }
}