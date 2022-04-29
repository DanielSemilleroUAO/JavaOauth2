package com.daniel.service;

import java.util.List;

import com.daniel.entity.User;

public interface UserService {
	
	public List<User> findAll();
	
	public void save(User user);
	
	public User findById(Long id);
	
}
