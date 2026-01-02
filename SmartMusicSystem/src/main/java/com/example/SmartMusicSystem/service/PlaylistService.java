package com.example.SmartMusicSystem.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.SmartMusicSystem.entity.*;
import com.example.SmartMusicSystem.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public PlaylistService(PlaylistRepository playlistRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    @Transactional
    public Playlist createPlaylist(Playlist playlist) {
        Playlist saved = playlistRepository.save(playlist);
        entityManager.flush();
        entityManager.clear(); // Clears cache so next find gets full names/titles
        return playlistRepository.findById(saved.getPlaylistId()).orElse(null);
    }

    @Transactional
    public Playlist addSongToPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        playlist.getSongs().add(song);
        return playlistRepository.save(playlist);
    }

    public Playlist getPlaylist(Long playlistId) {
        return playlistRepository.findById(playlistId).orElse(null);
    }
}