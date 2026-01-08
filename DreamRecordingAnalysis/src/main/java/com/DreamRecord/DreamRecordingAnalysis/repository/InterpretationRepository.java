package com.DreamRecord.DreamRecordingAnalysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DreamRecord.DreamRecordingAnalysis.model.Interpretation;

@Repository
public interface InterpretationRepository extends JpaRepository<Interpretation, Long> {
    List<Interpretation> findByDreamRecord_RecordId(Long recordId);
}