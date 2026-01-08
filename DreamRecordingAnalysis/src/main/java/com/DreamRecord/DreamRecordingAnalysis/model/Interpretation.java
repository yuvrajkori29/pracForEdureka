package com.DreamRecord.DreamRecordingAnalysis.model;

import jakarta.persistence.*;

@Entity
public class Interpretation{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long interpretationId;
	private String  analystName;
	private String symbolismNotes;
	private double confidenceScore;
	
	@ManyToOne
	private DreamRecord dreamRecord;

	
	
	
	
	
	
	
	public Interpretation() {
		super();
	}

	public Interpretation(Long interpretationId,  String analystName, String symbolismNotes,
			double confidenceScore, DreamRecord dreamRecord) {
		super();
		this.interpretationId = interpretationId;
	
		this.analystName = analystName;
		this.symbolismNotes = symbolismNotes;
		this.confidenceScore = confidenceScore;
		this.dreamRecord = dreamRecord;
	}

	public Long getInterpretationId() {
		return interpretationId;
	}

	public void setInterpretationId(Long interpretationId) {
		this.interpretationId = interpretationId;
	}

	
	public String getAnalystName() {
		return analystName;
	}

	public void setAnalystName(String analystName) {
		this.analystName = analystName;
	}

	public String getSymbolismNotes() {
		return symbolismNotes;
	}

	public void setSymbolismNotes(String symbolismNotes) {
		this.symbolismNotes = symbolismNotes;
	}

	public double getConfidenceScore() {
		return confidenceScore;
	}

	public void setConfidenceScore(double confidenceScore) {
		this.confidenceScore = confidenceScore;
	}

	public DreamRecord getDreamRecord() {
		return dreamRecord;
	}

	public void setDreamRecord(DreamRecord dreamRecord) {
		this.dreamRecord = dreamRecord;
	}
	
	
	
	
}