package com.rest.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.test.model.User;
import com.rest.test.service.UserServiceImpl;


@RestController
@RequestMapping("/users") // users 들어오는 URI 매핑
public class RestStudyController {
	
	// DI 의존성 주입 UserService 객체
	@Autowired
	private UserServiceImpl service;
	
	
	// 모든 유저 조회
	@GetMapping("")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	// 특정 유저 조회(아이디)
	@GetMapping("/{userid}")
	public User getUserByUserId(@PathVariable String userid) {
		return service.getUserByUserId(userid);
	}
	
	// 유저 등록
	@PostMapping("")
	public User registerUser(@RequestBody User user) {
		return service.registerUser(user);
	}
	
	// 유저 정보 수정
	@PutMapping("/{userid}")
	public void modifyUser(@PathVariable String userid, @RequestBody User user) {
		service.modifyUser(userid, user);
	}

	// 유저 삭제
	@DeleteMapping("/{userid}")
	public void removeUser(@PathVariable String userid) {
		service.removeUser(userid);
	}
}	
