package com.yeji.spring05.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yeji.spring05.dao.PocketmonDao;
import com.yeji.spring05.dto.PocketmonDto;

@RestController
public class PocketmonController {

	@Autowired
	private PocketmonDao dao;
	
	
	@RequestMapping("/insert")
	public String insert(
			@ModelAttribute PocketmonDto dto){
		dao.insert(dto);
		return "포켓몬 등록 완료!";
	}
	
	@RequestMapping("update")
	public String update(
			@ModelAttribute PocketmonDto dto) {
		boolean result = dao.update(dto);
		if(result) {
			return "포켓몬 업데이트 완료!";
		}else {
			return "해당정보는 존재하지 않습니다";
		}
	}
}
