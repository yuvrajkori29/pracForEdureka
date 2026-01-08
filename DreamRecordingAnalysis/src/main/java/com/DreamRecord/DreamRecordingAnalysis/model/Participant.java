package com.DreamRecord.DreamRecordingAnalysis.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Participant{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long participantId;
	
	private String name;
	private Long age;
	private Boolean sleepDisorderHistory;
	private String deviceId;
	
	@OneToMany(mappedBy = "participant" , cascade = CascadeType.ALL)
	private List<DreamRecord> listOfDreamRecords;

	

	
	
	public Participant() {
		super();
	}

	public Participant(Long participantId, String name, Long age, Boolean sleepDisorderHistory, String deviceId,
			List<DreamRecord> listOfDreamRecords) {
		super();
		this.participantId = participantId;
		this.name = name;
		this.age = age;
		this.sleepDisorderHistory = sleepDisorderHistory;
		this.deviceId = deviceId;
		this.listOfDreamRecords = listOfDreamRecords;
	}

	public Long getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Boolean getSleepDisorderHistory() {
		return sleepDisorderHistory;
	}

	public void setSleepDisorderHistory(Boolean sleepDisorderHistory) {
		this.sleepDisorderHistory = sleepDisorderHistory;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public List<DreamRecord> getListOfDreamRecords() {
		return listOfDreamRecords;
	}

	public void setListOfDreamRecords(List<DreamRecord> listOfDreamRecords) {
		this.listOfDreamRecords = listOfDreamRecords;
	}
	
	
	
	
	
}