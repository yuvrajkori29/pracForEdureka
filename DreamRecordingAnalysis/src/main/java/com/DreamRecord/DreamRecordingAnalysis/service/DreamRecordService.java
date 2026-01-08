package com.DreamRecord.DreamRecordingAnalysis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DreamRecord.DreamRecordingAnalysis.model.DreamRecord;
import com.DreamRecord.DreamRecordingAnalysis.model.Participant;
import com.DreamRecord.DreamRecordingAnalysis.repository.DreamRecordRepository;
import com.DreamRecord.DreamRecordingAnalysis.repository.ParticipantRepository;

@Service
public class DreamRecordService{
	
	private final DreamRecordRepository dreamRecordRepository;
		

	
	
	
	public DreamRecordService(DreamRecordRepository dreamRecordRepository) {
		super();
		this.dreamRecordRepository = dreamRecordRepository;
	
	}

	public DreamRecord addDreamRecord(DreamRecord dreamRecord)
	{  
		return dreamRecordRepository.save(dreamRecord);
	}
	
	public DreamRecord getDreamDetails(Long recordId)
	{ 
		return dreamRecordRepository.findById(recordId).orElse(null);
	}
	
	
	public List<DreamRecord> listDreamsForParticipant(Long participantId)
	{
		return dreamRecordRepository.findByParticipant_ParticipantId(participantId);
	}
	
}





//public DreamRecordService(DreamRecordRepository dreamRecordRepository,
//		ParticipantRepository participantRepository) {
//	super();
//	this.dreamRecordRepository = dreamRecordRepository;
//	this.participantRepository = participantRepository;
//}
//
//public DreamRecord addDreamRecord(DreamRecord dreamRecord)
//{  
//	Long  participantId = dreamRecord.getParticipantId();
//	Participant participant = participantRepository.findById(participantId);
//	
//	return dreamRecordRepository.save(dreamRecord);
//}