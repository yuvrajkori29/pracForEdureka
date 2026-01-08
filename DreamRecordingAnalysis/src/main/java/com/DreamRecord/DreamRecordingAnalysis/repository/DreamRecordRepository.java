package com.DreamRecord.DreamRecordingAnalysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DreamRecord.DreamRecordingAnalysis.model.DreamRecord;
@Repository
public interface DreamRecordRepository extends JpaRepository<DreamRecord, Long> {
    List<DreamRecord> findByParticipant_ParticipantId(Long participantId);
}
