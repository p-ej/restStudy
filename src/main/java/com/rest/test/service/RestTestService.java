package com.rest.test.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


// 비즈니스 로직을 처리하는 어노테이션과 클래스 
@Service 
public class RestTestService {

	public Map<String, String> getJson(){
		Map<String, String> map = new HashMap<>();
		map.put("rest test key Service ", "im value hihi Service");
		return map;
	}
	
}

