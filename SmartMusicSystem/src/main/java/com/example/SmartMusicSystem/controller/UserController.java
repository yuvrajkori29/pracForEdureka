package com.example.SmartMusicSystem.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartMusicSystem.entity.User;
import com.example.SmartMusicSystem.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController{
	
	@Autowired
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	//register user
	
	@PostMapping
	public User registerUser(@RequestBody User user)
	{
		return userService.registerUser(user);
	}
	
	
	//getUser by id
	@GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }
	
	
}