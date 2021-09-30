package com.rest.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.test.service.RestTestService;

// 컨트롤러의 역할을 한다
@RestController
@RequestMapping("/") // 해당 컨트롤러로 들어오는 전체 매핑 URL은  "/" 로 지정
public class RestTestController {
	
	// log test
	private static final Logger logger = LoggerFactory.getLogger(RestTestController.class);
	
	// DI 의존성주입 부분 2가지 방법
	
//	@Autowired
//	private RestTestService service;
	
	private final RestTestService service;
	
	public RestTestController(RestTestService service) {
		this.service = service;
	}
	
	// 매핑 URI는 아무 값도 없이 지정
	@GetMapping("")
	public String test() {
		logger.info("RestTestController test Method");
		return "root url call !"; 
		// RestController는 반환을 JSON으로 해준다. 일반 Controller 어노테이션이랑은 반환 타입이 다름
	}
	
	// json 데이터 요청 테스트  (나중에는 TDD로 변경해보기)
	@GetMapping("/json")
	public Map<String, String> jsonTest(){
		logger.info("RestTestController jsonTest Method");
		Map<String, String> map = new HashMap<>();
		map.put("rest test key", "im value hihi");
		logger.info("json type map value : '{}'",map);
		return map;
	}
	
	// 스프링 비즈니스 계층으로 나뉘어 Service를 불러와 값을 응답받음.
	@GetMapping("/jsonService")
	public Map<String,String> jsonMethod(){
		Map<String,String> map = service.getJson();
		return map;
	}
}
