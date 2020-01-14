package com.jwt.rest.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.rest.demo.model.User;
import com.jwt.rest.demo.repo.UserRespository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRespository userRespository;

	@Override
	public List<User> getAllUsers() {
		return userRespository.findAll();
	}

	@Override
	public User addUser(User user) {
		return userRespository.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		Optional<User> updateUser = userRespository.findById(id);
		if(updateUser.isPresent()) {
			if(user.getFirstName() != null) {
				updateUser.get().setFirstName(user.getFirstName());
			}
			if(user.getLastName() != null) {
				updateUser.get().setLastName(user.getLastName());
			}
			if(user.getEmail() != null) {
				updateUser.get().setEmail(user.getEmail());
			}
			if(user.getPhone() != null) {
				updateUser.get().setPhone(user.getPhone());
			}
			
		}
		return userRespository.save(updateUser.get());
	}

	@Override
	public void removeUser(Long id) {
		userRespository.deleteById(id);

	}

}
