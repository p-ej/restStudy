package com.rest.test.dao;

import java.util.List;

import com.rest.test.model.User;

public interface UserDao {
	// 모든 유저 조회
	public List<User> getAllUsers();
	
	// 특정 유저 조회 아이디 검색
	public User getUserByUserId(String userid);
	
	// 유저 등록
	public User insertUser(User user);
	
	// 유저 정보 수정
	public void updateUser(String userId, User user);
	
	// 유저 삭제
	public void deleteUser(String userId);
}
