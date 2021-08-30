package com.rest.es.restfulservices.controller;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.dao.UserDaoService;
import com.rest.dao.exception.UserNotFoundException;
import com.rest.entity.User;

@RestController
public class UserController {
	/*
	 * 
	 * @RequestMapping(path = "/msg") public Message getMsg() { return new
	 * Message("gud morning"); }
	 * 
	 * @RequestMapping(path = "/msg/{name}") public Message
	 * getMsgwithName(@PathVariable String name) { return new
	 * Message(String.format("gud morning - %s", name)); }
	 * 
	 */

	@Autowired
	private UserDaoService daoService;

	@PostMapping(path = "/add-user")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		daoService.saveUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(user.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping(path = "/users")
	public List<User> getAllUser() {
		return daoService.gwtAllUser();
	}

	@GetMapping(path = "/user/{id}")
	public User getAllUser(@PathVariable int id) {
		User user = daoService.getUser(id);
		if (user == null) {
			throw new UserNotFoundException("id: " + id);
		}
		return user;
	}
	
	
	@DeleteMapping(path = "/user/{id}")
	public void removeUser(@PathVariable int id) {
		daoService.removeUser(id);
	}

}