package com.example.SmartMusicSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartMusicSystem.entity.Playlist;
import com.example.SmartMusicSystem.entity.Song;
import com.example.SmartMusicSystem.repository.PlaylistRepository;
import com.example.SmartMusicSystem.repository.SongRepository;

import jakarta.transaction.Transactional;

@Service
public class PlaylistService{
	
	@Autowired
	private final PlaylistRepository playlistRepository;

	@Autowired
	private final SongRepository songRepository;
	
	
	public PlaylistService(PlaylistRepository playlistRepository, SongRepository songRepository) {
		super();
		this.playlistRepository = playlistRepository;
		this.songRepository = songRepository;
	}

	
	
	//method to add Playlist
	@Transactional
	public Playlist createPlaylist(Playlist playlist)
	{
		playlistRepository.save(playlist);
		return playlist;
	}
	
	
	//method to add song to playlist
	@Transactional
    public Playlist addSongToPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        Song song = songRepository.findById(songId).orElse(null);

        playlist.getSongs().add(song);
        return playlistRepository.save(playlist);
    }
    
    //get playlist
	@Transactional
    public Playlist getPlaylist(Long playlistId)
    {
    	return playlistRepository.findById(playlistId).orElse(null);
    	
    }
    
    //getAllPlayList
	@Transactional
    public  List<Playlist> getAllPlaylists()
    {
    	return playlistRepository.findAll();
    }
  
}