package com.example.SmartMusicSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmartMusicSystem.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	
}