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
import com.jwt.rest.demo.service.UserAPIService;

@RestController
@RequestMapping("/api/v2")
public class ApiController {

	@Autowired
	UserAPIService userAPIService;

	@GetMapping("/getData")
	public List<User> getData() {
		return userAPIService.getInfo();
	}

	@PostMapping("/postdata")
	public User postData(@RequestBody User user) {
		return userAPIService.saveData(user);
	}
	
	@PatchMapping("/updatedata/{id}")
    public User updateData(@RequestBody User user, @PathVariable Long id){
        return userAPIService.updateData(user, id);
    }
	
	@DeleteMapping("/deletedata/{id}")
    public void deleteData(@PathVariable Long id){
		userAPIService.deleteData(id);
    }

}
