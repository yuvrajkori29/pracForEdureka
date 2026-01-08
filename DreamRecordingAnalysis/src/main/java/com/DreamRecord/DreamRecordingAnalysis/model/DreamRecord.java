package com.DreamRecord.DreamRecordingAnalysis.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class DreamRecord{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recordId;
	private LocalDateTime timestamp;
	private String dreamSummary;
	private String emotionalTone;
	private Long participantId;
	
	@ManyToOne
	private Participant participant;
	
	@OneToMany(mappedBy = "dreamRecord" , cascade = CascadeType.ALL )
	private List<Interpretation> listOfIntreprtations;

	
	
	
	
	public DreamRecord() {
		super();
	}

	
	public DreamRecord(Long recordId, LocalDateTime timestamp, String dreamSummary, String emotionalTone,
			Long participantId, Participant participant, List<Interpretation> listOfIntreprtations) {
		super();
		this.recordId = recordId;
		this.timestamp = timestamp;
		this.dreamSummary = dreamSummary;
		this.emotionalTone = emotionalTone;
		this.participantId = participantId;
		this.participant = participant;
		this.listOfIntreprtations = listOfIntreprtations;
	}


	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getDreamSummary() {
		return dreamSummary;
	}

	public void setDreamSummary(String dreamSummary) {
		this.dreamSummary = dreamSummary;
	}

	public String getEmotionalTone() {
		return emotionalTone;
	}

	public void setEmotionalTone(String emotionalTone) {
		this.emotionalTone = emotionalTone;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Long getParticipantId() {
		return participantId;
	}


	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
	}


	public List<Interpretation> getListOfIntreprtations() {
		return listOfIntreprtations;
	}

	public void setListOfIntreprtations(List<Interpretation> listOfIntreprtations) {
		this.listOfIntreprtations = listOfIntreprtations;
	}

	
}
