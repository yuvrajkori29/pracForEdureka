package com.example.SmartMusicSystem.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
@Table(name = "playlist_tbl")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playlistId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "playlist_song",
        joinColumns = @JoinColumn(name = "playlist_id"),
        inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> songs;

    public Playlist() {}

    public Long getPlaylistId() { return playlistId; }
    public void setPlaylistId(Long playlistId) { this.playlistId = playlistId; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public List<Song> getSongs() { return songs; }
    public void setSongs(List<Song> songs) { this.songs = songs; }
}