package com.rest.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rest.test.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	// DB 세팅 전 임시로 유저 객체 생성하고 담을 users 리스트 객체
	public static List<User> users;
	
	// 유저 정적생성 
	static {
		users = new ArrayList<User>();
		users.add(new User(1,"testName1","testid1","1234"));
		users.add(new User(2,"testName2","testid2","1234"));
		users.add(new User(3,"testName3","testid3","1234"));
		users.add(new User(4,"testName4","testid4","1234"));
		users.add(new User(5,"testName5","testid5","1234"));
	}
	
	// 모든 유저 조회
	@Override
	public List<User> getAllUsers() {
		return users;
	}

	// 특정 유저 검색(아이디)
	@Override
	public User getUserByUserId(String userid) {
		return users
				.stream()
				.filter(user -> user.getUserId().equals(userid))
				.findAny()
				.orElse(new User(-1, "","",""));
	}

	// 유저 등록
	@Override
	public User insertUser(User user) {
		users.add(user);
		
		return user;
	}

	// 유저 정보 수정
	@Override
	public void updateUser(String userId, User user) {
		users.stream()
		.filter(curUser -> curUser.getUserId().equals(userId))
		.findAny()
		.orElse(new User(-1,"","",""))
		.setUserName(user.getUserName());
	}

	// 유저 삭제
	@Override
	public void deleteUser(String userId) {
		users.removeIf(user -> user.getUserId().equals(userId));
	}

}
