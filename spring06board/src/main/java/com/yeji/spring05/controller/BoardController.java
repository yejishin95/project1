package com.yeji.spring05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yeji.spring05.dao.BoardDao;
import com.yeji.spring05.dto.BoardDto;

@RestController
public class BoardController {

	@Autowired
	private BoardDao dao;
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto) {
		dao.insert(dto);
		return "게시글 작성 완료!";
	}
	
	
}
