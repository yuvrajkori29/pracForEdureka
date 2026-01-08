package com.DreamRecord.DreamRecordingAnalysis.model;

import java.time.LocalDateTime;

import com.DreamRecord.DreamRecordingAnalysis.model.dto.alertType;

import jakarta.persistence.*;

@Entity
public class AnomalyAlert{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alertId;
	
	private alertType type;
	private LocalDateTime timestamp;
	private Long participantId;
	
	
	@ManyToOne
	private Participant participant;

	
	
	
	public AnomalyAlert() {
		super();
	}




	public AnomalyAlert(Long alertId, alertType type, LocalDateTime timestamp, Long participantId,
			Participant participant) {
		super();
		this.alertId = alertId;
		this.type = type;
		this.timestamp = timestamp;
		this.participantId = participantId;
		this.participant = participant;
	}




	public Long getParticipantId() {
		return participantId;
	}





	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
	}





	public Long getAlertId() {
		return alertId;
	}

	public void setAlertId(Long alertId) {
		this.alertId = alertId;
	}

	

	public alertType getType() {
		return type;
	}

	public void setType(alertType type) {
		this.type = type;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	
	
	
}