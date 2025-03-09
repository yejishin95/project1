package com.yeji.spring04.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PocketmonController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/insert")
	public String insert(
			@RequestParam int no,
			@RequestParam String name,
			@RequestParam String type){
		String sql = "insert into pocketmon(no,name,type) "
				+ "values(?,?,?)";
		Object[] data = {no, name, type};
		jdbcTemplate.update(sql, data);
		
		return "등록 완료";
	}
}
