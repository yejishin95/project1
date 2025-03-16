package com.yeji.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yeji.spring07.dao.BookDao;
import com.yeji.spring07.dto.BookDto;

@RestController
public class BookController {

	@Autowired BookDao dao;
	
	@RequestMapping("/save")
	public String save(@ModelAttribute BookDto dto) {
		dao.insert(dto);
		return "도서 등록 완료";
	}
	@RequestMapping("/list")
	public String list() {
		List<BookDto> list = dao.selectList();
		return list.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int bookId) {
		BookDto dto = dao.selectOne(bookId);
		if(dto == null) {
			return "해당 도서는 없는 도서입니다";
		}else {
			return dto.toString();
		}
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute BookDto dto) {
		boolean result = dao.update(dto);
		if(result) {
			return "도서 정보 수정 완료";
		}else {
			return "해당 도서는 없는 도서입니다";
		}
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int BookId) {
		boolean result = dao.delete(BookId);
		if(result) {
			return "도서 삭제 완료";
		}else {
			return "해당 도서는 존재하지 않습니다";
		}
	}
}
