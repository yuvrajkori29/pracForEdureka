//userid,username,email

package com.example.SmartMusicSystem.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	
	private String username;
	
	private String email;



	
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Playlist> listOfPlayList;


    
    
	public User() {
		super();
	}

	public User(Long userId, String username, String email, List<Playlist> listOfPlayList) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.listOfPlayList = listOfPlayList;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Playlist> getListOfPlayList() {
		return listOfPlayList;
	}

	public void setListOfPlayList(List<Playlist> listOfPlayList) {
		this.listOfPlayList = listOfPlayList;
	}
	
    
	
	
	
	
}