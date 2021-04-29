package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.User;
import com.axis.service.UserService;

@RestController
@RequestMapping
public class UserController {
	
	@Autowired
	private UserService service;

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping("/getUsers")
	public List<User> findAllUsers() {
		return service.getUsers();
	}
	
	@DeleteMapping("/remove")
	public User deleteUser(@RequestBody User user) {
		return service.deleteUser(user);
	}
	
}
