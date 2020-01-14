package com.jwt.rest.demo.service;

import java.util.List;

import com.jwt.rest.demo.model.User;

public interface UserAPIService {

	public List<User> getInfo();

	public User saveData(User requestUser);

	public User updateData(User requestUser, Long id);

	public void deleteData(Long id);

}
