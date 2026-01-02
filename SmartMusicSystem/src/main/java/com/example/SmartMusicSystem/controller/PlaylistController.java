package com.example.SmartMusicSystem.controller;

import org.springframework.web.bind.annotation.*;
import com.example.SmartMusicSystem.entity.Playlist;
import com.example.SmartMusicSystem.service.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    // POST http://localhost:1234/playlists
    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    // PUT http://localhost:1234/playlists/1/addSong/2
    @PutMapping("/{playlistId}/addSong/{songId}")
    public Playlist addSongToPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) {
        return playlistService.addSongToPlaylist(playlistId, songId);
    }

    // GET http://localhost:1234/playlists/1
    @GetMapping("/{playlistId}")
    public Playlist getPlaylist(@PathVariable Long playlistId) {
        return playlistService.getPlaylist(playlistId);
    }
}