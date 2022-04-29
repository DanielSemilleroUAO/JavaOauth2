package com.daniel.dao;

import org.springframework.data.repository.CrudRepository;

import com.daniel.entity.User;

public interface UserDao extends CrudRepository<User, Long>{
	
	public User findByUsername(String username);
	
}
