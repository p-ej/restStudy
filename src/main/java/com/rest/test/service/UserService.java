package com.rest.test.service;

import java.util.List;

import com.rest.test.model.User;

public interface UserService {
	
	// 모든 유저 조회
	public List<User> getAllUsers();
	
	// 특정 유저 조회(id로)
	public User getUserByUserId(String userid);
	
	// 유저 등록
	public User registerUser(User user);
	
	// 유저 수정
	public void modifyUser(String userId, User user);
	
	// 유저 삭제
	public void removeUser(String userId);
}
