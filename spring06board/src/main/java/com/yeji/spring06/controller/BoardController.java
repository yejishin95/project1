package com.yeji.spring06.controller;

import java.util.List;

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
	
	@RequestMapping("/list")
	public String list(){
		List<BoardDto> list = dao.selectList();
		StringBuffer buffer = new StringBuffer();
		for(BoardDto dto:list) {
			buffer.append("[");
			buffer.append(dto.getBoardNo());
			buffer.append("]");
			buffer.append(" ");
			buffer.append(dto.getBoardTitle());
			buffer.append(" - ");
			buffer.append(dto.getBoardWriter());
			buffer.append(" (조회수 : ");
			buffer.append(dto.getBoardReadcount());
			buffer.append(")\n");
		}
		return buffer.toString();
	}
	
	@RequestMapping("/list2")
	public String list2() {
		List<BoardDto> list = dao.detail();
		StringBuffer buffer = new StringBuffer();
		for(BoardDto dto : list) {
			buffer.append(dto.getBoardNo());
			buffer.append(dto.getBoardTitle());
			buffer.append(dto.getBoardContent());
			buffer.append(dto.getBoardWriter());
			buffer.append(dto.getBoardReadcount());
		}
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int boardNo) {
		BoardDto dto = dao.selectOne(boardNo);
		if(dto == null) {
			return "존재하지 않는 게시글";
		}
		else {
			return dto.toString();
		}
	}
	
	
}
