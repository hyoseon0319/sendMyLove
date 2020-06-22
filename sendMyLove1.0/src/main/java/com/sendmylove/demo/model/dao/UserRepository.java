package com.sendmylove.demo.model.dao;

import org.springframework.data.repository.CrudRepository;

import model.domain.User;

public interface UserRepository extends CrudRepository<User, String>{
	
}
