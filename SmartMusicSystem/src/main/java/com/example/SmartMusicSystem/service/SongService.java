package com.example.SmartMusicSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartMusicSystem.entity.Song;
import com.example.SmartMusicSystem.repository.SongRepository;


@Service
public class SongService {

    @Autowired
    private SongRepository repo;

    public Song addSong(Song song) {
        return repo.save(song);
    }

    public Song getSong(Long id) {
        // Using orElseThrow helps you see exactly what's wrong in the logs
        return repo.findById(id).orElseThrow(() -> 
            new RuntimeException("Song not found with id: " + id));
    }
}