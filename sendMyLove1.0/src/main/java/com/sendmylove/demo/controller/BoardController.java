package com.sendmylove.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sendmylove.demo.model.dao.BoardRepository;

import model.domain.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardRepository boardRepo;

	@PostMapping("insertBoard")
	public String insertBoard(HttpSession session, @RequestParam String gender, @RequestParam String date,
			@RequestParam String detailtime, @RequestParam String sido, @RequestParam String gugun,
			@RequestParam String dong, @RequestParam String loc, @RequestParam String detail) {
		String currId = (String) session.getAttribute("id");
		String finalloc = sido + " " + gugun + " " + dong + " " + loc;
		String finddate = date + " " + detailtime;
		Date writedate = new Date();
		try {
			Board b = new Board();
			b.setWriter(currId);
			b.setDetail(detail);
			b.setGender(gender);
			b.setFinddate(finddate);
			b.setWritedate(writedate);
			b.setLoc(finalloc);
			boardRepo.save(b);
			return "redirect:index.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:fail.html";
		}
	}

}
