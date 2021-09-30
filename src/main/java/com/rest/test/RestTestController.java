package com.rest.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러의 역할을 한다
@RestController
@RequestMapping("/") // 해당 컨트롤러로 들어오는 전체 매핑 URL은  "/" 로 지정
public class RestTestController {
	
	// 매핑 URI는 아무 값도 없이 지정
	@GetMapping("")
	public String test() {
		return "root url call !"; 
		// RestController는 반환을 문자로 해준다. 일반 Controller 어노테이션이랑은 반환 타입이 다름
	}
}
