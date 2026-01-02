package com.example.SmartMusicSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.SmartMusicSystem.entity.Song;
import com.example.SmartMusicSystem.service.SongService;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService service;

    // POST http://localhost:1234/songs
    @PostMapping
    public Song addSong(@RequestBody Song song) {
        return service.addSong(song);
    }

    // GET http://localhost:1234/songs/1
    @GetMapping("/{id}")
    public Song getSong(@PathVariable("id") Long id) {
        return service.getSong(id);
    }
}