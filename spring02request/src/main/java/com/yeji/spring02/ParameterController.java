package com.yeji.spring02;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {

	// 두 개의 값을 파라미터로 받아서 합계를 출력
	@RequestMapping("/plus")
	public String plus(int left, int right){
		int total = left+right;
		return "합계 = " + total;
		//http://localhost:8080/plus?left=2&right=3
	}
}

