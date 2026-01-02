package com.example.SmartMusicSystem.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "song_tbl")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;
    private String title;
    private Long duration;
    private String artist;

    @ManyToMany(mappedBy = "songs")
    @JsonIgnore // CRITICAL: Prevents Song -> Playlist -> Song loop
    private List<Playlist> listOfPlaylists;

	public Song() {
		super();
	}


	public Song(Long songId, String title, Long duration, String artist, List<Playlist> listOfPlaylists) {
		super();
		this.songId = songId;
		this.title = title;
		this.duration = duration;
		this.artist = artist;
		this.listOfPlaylists = listOfPlaylists;
	}


	public Long getSongId() {
		return songId;
	}


	public void setSongId(Long songId) {
		this.songId = songId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Long getDuration() {
		return duration;
	}


	public void setDuration(Long duration) {
		this.duration = duration;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public List<Playlist> getListOfPlaylists() {
		return listOfPlaylists;
	}


	public void setListOfPlaylists(List<Playlist> listOfPlaylists) {
		this.listOfPlaylists = listOfPlaylists;
	}
	
	

}
	