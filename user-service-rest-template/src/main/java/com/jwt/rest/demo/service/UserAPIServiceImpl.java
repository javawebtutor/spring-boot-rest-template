package com.jwt.rest.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.jwt.rest.demo.model.User;

@Service
public class UserAPIServiceImpl implements UserAPIService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<User> getInfo() {
		String url = "http://localhost:8085/api/v1/users";

		ResponseEntity<List<User>> result = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});
		List<User> userList = new ArrayList<>();
		userList.addAll(result.getBody());

		return userList;

	}

	@Override
	public User saveData(User requestUser) {
		String url = "http://localhost:8085/api/v1/adduser";
		ResponseEntity<User> result = restTemplate.postForEntity(url, requestUser, User.class);
		User user = new User();
		user.setFirstName(result.getBody().getFirstName());
		user.setLastName(result.getBody().getLastName());
		user.setEmail(result.getBody().getEmail());
		user.setPhone(result.getBody().getPhone());
		return user;
	}

	@Override
	public User updateData(User requestUser, Long id) {
		String url = "http://localhost:8090/api/v1/patchuser/" + id;
		User result = restTemplate.patchForObject(url, requestUser, User.class);
		User user = new User();

        if(result != null) {
            if (requestUser.getFirstName() != null) {
                user.setFirstName(result.getFirstName());
            }
            if (requestUser.getLastName() != null) {
                user.setLastName(result.getLastName());
            }
            if (requestUser.getEmail() != null) {
                user.setEmail(((User) result).getEmail());
            }
            if (requestUser.getPhone() != null) {
                user.setPhone(result.getPhone());
            }
        }
        return user;
	}

	@Override
	public void deleteData(Long id) {
		 String url = "http://localhost:8085/api/v1/deleteuser/" + id;
		 try {
			restTemplate.delete(url);
		} catch (RestClientException e) {
			e.printStackTrace();
		}

	}

}
