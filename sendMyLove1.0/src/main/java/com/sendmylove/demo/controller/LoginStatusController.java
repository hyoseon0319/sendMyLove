package com.sendmylove.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sendmylove.demo.model.dao.UserRepository;

import model.domain.User;

@RestController
public class LoginStatusController {
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("currStatus")
	public Optional<User> currStatus(HttpSession session) {
		String currId = (String) session.getAttribute("id");
		return userRepo.findById(currId);

	}
}
