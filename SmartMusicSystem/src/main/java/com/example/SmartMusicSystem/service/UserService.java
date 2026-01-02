package com.example.SmartMusicSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartMusicSystem.entity.User;
import com.example.SmartMusicSystem.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService{
	
	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	//method to get user
	@Transactional
	public User getUser(Long userId)
	{
		User userOptional  = userRepository.findById(userId).orElse(null);
		return userOptional;
	}
	
	
	//method to fetch all users
	@Transactional
	public List<User> getAllUsers()
	{
		List<User> userList = userRepository.findAll();
		return userList;
	}
	
	//method to add User
	@Transactional
	public User registerUser(User user)
	{
		userRepository.save(user);
		return user;
	}
	
	
}