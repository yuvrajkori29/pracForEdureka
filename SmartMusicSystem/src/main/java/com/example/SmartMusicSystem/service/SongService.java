package com.example.SmartMusicSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartMusicSystem.entity.Song;
import com.example.SmartMusicSystem.repository.SongRepository;

import jakarta.transaction.Transactional;

@Service
public class SongService {

    @Autowired
    private final SongRepository songRepository;
    

    public SongService(SongRepository repo) {
		super();
		this.songRepository = repo;
	}
    
    //method to add Song
    @Transactional
	public Song addSong(Song song) {
        return songRepository.save(song);
    }
  
	//method to get song
    @Transactional
    public Song getSong(Long id) {
        return songRepository.findById(id).orElse(null);
    }
}