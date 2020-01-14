package com.jwt.rest.demo.service;

import java.util.List;

import com.jwt.rest.demo.model.User;

public interface UserService {

	public List<User> getAllUsers();

	public User addUser(User user);

	public User updateUser(Long id, User user);

	public void removeUser(Long id);

}
