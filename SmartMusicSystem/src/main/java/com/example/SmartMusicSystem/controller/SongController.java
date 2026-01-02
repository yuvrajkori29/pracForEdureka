package com.example.SmartMusicSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartMusicSystem.entity.Song;
import com.example.SmartMusicSystem.service.SongService;

@RestController
@RequestMapping({"/{songs}"})
public class SongController{
	@Autowired
	public final SongService songService;

	public SongController(SongService songService) {
		super();
		this.songService = songService;
	}
	
	
	//method to add song
	@PostMapping
	public Song addSong(@RequestBody Song song)
	{
		songService.addSong(song);
		return song;
	}
	
	
	//method to get Song
	@GetMapping({"/{id}"})
	public Song getSong(@PathVariable Long songId)
	{
		return songService.getSong(songId);
		}
	
}