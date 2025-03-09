package com.yeji.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yeji.spring06.dao.BoardDao;
import com.yeji.spring06.dto.BoardDto;

@RestController
public class BoardController {

	@Autowired
	private BoardDao dao;
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto) {
		dao.insert(dto);
		return "게시글 작성 완료!";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute BoardDto dto) {
		boolean result = dao.update(dto);
		if(result) {
			return "게시글 업데이트 완료!";			
		}else {
			return "해당하는 게시글이 없습니다";
		}
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boolean result = dao.delete(boardNo);
		if(result) {
			return "게시글 삭제 완료";
		}else {
			return "해당 게시글 존재하지 않습니다";
		}
	}
	
	
}
