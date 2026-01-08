package com.DreamRecord.DreamRecordingAnalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DreamRecord.DreamRecordingAnalysis.model.Participant;
@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {}