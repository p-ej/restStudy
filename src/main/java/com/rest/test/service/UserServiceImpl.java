package com.rest.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.test.dao.UserDao;
import com.rest.test.dao.UserDaoImpl;
import com.rest.test.model.User;

@Service
public class UserServiceImpl implements UserService{

	// 데이터 영역 계층이랑 통신을 하기 위한 의존성 설정 (의존성 주입 : DI)
	@Autowired
	private UserDaoImpl userDao;
	
	// 모든 유저 조회
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	// 특정 유저 조회(아이디)
	@Override
	public User getUserByUserId(String userid) {
		return userDao.getUserByUserId(userid);
	}

	// 유저 등록
	@Override
	public User registerUser(User user) {
		return userDao.insertUser(user);
	}

	// 유저 정보 수정
	@Override
	public void modifyUser(String userId, User user) {
		userDao.updateUser(userId, user);
	}

	// 유저 삭제
	@Override
	public void removeUser(String userId) {
		userDao.deleteUser(userId);
	}

}
