package com.example.crudDemo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.crudDemo.model.User;
import com.example.crudDemo.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

    // Constructor injection is preferred over @Autowired on fields
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User updateUser(Long id, User userDetails) {
		return userRepository.findById(id).map(existingUser -> {
			existingUser.setUserName(userDetails.getUserName());
			existingUser.setUserEmail(userDetails.getUserEmail());
			return userRepository.save(existingUser);
		}).orElse(null);
	}
	
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}