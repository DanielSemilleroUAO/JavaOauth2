package com.daniel.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.dao.UserDao;
import com.daniel.entity.User;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).orElse(null);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userDao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Usario no valido");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE ADMIN")));
	}

}
