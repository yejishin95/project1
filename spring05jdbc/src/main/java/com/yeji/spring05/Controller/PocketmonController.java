package com.yeji.spring05.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yeji.spring05.dao.PocketmonDao;
import com.yeji.spring05.dto.PocketmonDto;

@RestController
public class PocketmonController {

	@Autowired
	private PocketmonDao dao;
	
	@Autowired
	private PocketmonDto dto;
	
	@RequestMapping("/insert")
	public String insert(
			@ModelAttribute PocketmonDto dto){
		dao.insert(dto);
		return "포켓몬 등록 완료!";
	}
}
