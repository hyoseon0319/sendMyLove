package com.sendmylove.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sendmylove.demo.model.dao.UserRepository;

import model.domain.User;

@Controller
//@RestController
public class LoginController {
	@Autowired
	private UserRepository userRepo;

	@PostMapping("insertUser")
	public String insertUser(@RequestParam String id, @RequestParam String password, @RequestParam String nickname) {
		try {
			if (userRepo.existsById(id)) {
				return "redirect:fail.html";
			} else {
				userRepo.save(new User(id, password, nickname));
				return "redirect:success.html";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:index.html";
		}
	}

	@PostMapping("loginUser")
	public String loginUser(@RequestParam String id, @RequestParam String password, HttpSession session) {
		try {
			if (userRepo.existsById(id)) {
				if (userRepo.findById(id).get().getPassword().equals(password)) {
					session.setAttribute("id", id);
					//return "loginsuccess";
					return "redirect:index.html";
				}
			} else {
				return "redirect:fail.html";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:fail.html";
		}
		return "redirect:index.html";
	}

	@GetMapping("logoutUser")
	public String logoutUser(HttpSession session) {
		System.out.println(session.getAttribute("id"));
		session.removeAttribute("id");
		// return "redirect:index.html";
		return "redirect:index.html";

	}
	
	
	
	
}