package com.example.SmartMusicSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmartMusicSystem.entity.Playlist;
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>
{
	
}