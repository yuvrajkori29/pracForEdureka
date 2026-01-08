package com.DreamRecord.DreamRecordingAnalysis;

import com.DreamRecord.DreamRecordingAnalysis.model.Participant;
import com.DreamRecord.DreamRecordingAnalysis.repository.ParticipantRepository;
import com.DreamRecord.DreamRecordingAnalysis.service.ParticipantService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Initializes mocks automatically
class ParticipantServiceTest {

    @Mock
    private ParticipantRepository repository;

    @InjectMocks
    private ParticipantService service;

    private Participant participant;

    @BeforeEach
    void setUp() {
        participant = new Participant();
        participant.setParticipantId(1L);
        participant.setName("John");
    }

    @Test
    void testGetById_Success() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(participant));

        // Act
        Participant result = service.getById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getName());
        verify(repository, times(1)).findById(1L);
    }
}