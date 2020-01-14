package com.jwt.rest.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.rest.demo.model.User;

public interface UserRespository extends JpaRepository<User, Long> {

}
