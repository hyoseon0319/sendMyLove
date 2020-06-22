package com.sendmylove.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.sendmylove.demo.model.dao.BoardRepository;

import model.domain.Board;

@RestController
public class PostsController {
	@Autowired
	private BoardRepository boardRepo;
	
	@GetMapping("selectAllPosts")
	public Iterable<Board> selectAllPosts() {
		return boardRepo.findAll();
	}
}
