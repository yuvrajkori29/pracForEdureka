package com.DreamRecord.DreamRecordingAnalysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DreamRecord.DreamRecordingAnalysis.model.AnomalyAlert;
@Repository
public interface AnomalyAlertRepository extends JpaRepository<AnomalyAlert, Long> {
    List<AnomalyAlert> findByParticipant_ParticipantId(Long participantId);
}