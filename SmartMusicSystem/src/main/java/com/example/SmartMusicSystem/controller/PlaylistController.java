package com.example.SmartMusicSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartMusicSystem.entity.Playlist;
import com.example.SmartMusicSystem.service.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private final PlaylistService playlistService;
    
    

    public PlaylistController(PlaylistService playlistService) {
		super();
		this.playlistService = playlistService;
	}

	@PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    @PutMapping("/{id}/addSong/{songId}")
    public Playlist addSongToPlaylist(@PathVariable Long id,
                                       @PathVariable Long songId) {
        return playlistService.addSongToPlaylist(id, songId);
    }

    @GetMapping("/{id}")
    public Playlist getPlaylist(@PathVariable Long id) {
        return playlistService.getPlaylist(id);
    }
}