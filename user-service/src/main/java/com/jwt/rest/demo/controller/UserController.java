package com.jwt.rest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.rest.demo.model.User;
import com.jwt.rest.demo.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/adduser")
	public User saveUser(@RequestBody User user) {
		return userService.addUser(user);

	}

	@PatchMapping(("/patchuser/{id}"))
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.removeUser(id);
    }

}
