package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.model.User;
import com.axis.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public User addUser(User user) {
		return repo.save(user);
	}
	
	public List<User> getUsers() {
		return repo.findAll();
	}
	
	public User deleteUser(User user) {
		return repo.delete(user);
	}

}
