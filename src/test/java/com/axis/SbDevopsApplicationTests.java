package com.axis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.axis.model.User;
import com.axis.repo.UserRepository;
import com.axis.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SbDevopsApplication.class})
class SbDevopsApplicationTests {
	
	@Autowired
	UserService service;
	
	@MockBean
	UserRepository repo;
	
	@Test
	public void getUserTest() {
		when(repo.findAll()).thenReturn(Stream
				.of(new User(371, "Mayank", "Haridwar", 25), new User(372, "Shivam", "Haridwar", 23)).collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
	}
	
	@Test
	public void saveUserTest() {
		User user = new User(999, "Maya", "Delhi", 26);
		when(repo.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}
	
	@Test
	public void deleteUserTest() {
		User user = new User(999, "Maya", "Delhi", 26);
		service.deleteUser(user);
		verify(repo, times(1)).delete(user);
	}
}
