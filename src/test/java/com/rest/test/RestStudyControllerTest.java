package com.rest.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.test.controller.RestStudyController;
import com.rest.test.model.User;

@RunWith(SpringJUnit4ClassRunner.class) // 해당 어노테이션은 JUnit 프레임워크의 테스트 실행방법을 확장할 때 사용하는 어노테이션
@WebAppConfiguration // 웹 애플리케이션 전용 DI 컨테이너로 처리
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
// Spring Bean 메타 설정 파일의 패키지에서 설정 파일을 찾습니다. (설정 파일의 위치를 지정할 때 사용함.)
public class RestStudyControllerTest {
	/*
	 * RestStudyController의 요청응답을 테스트할 컨트롤러 
	 */
	private static final Logger logger = LoggerFactory.getLogger(RestStudyControllerTest.class);

	// Autowired와 유사함.
	@Inject
	private WebApplicationContext wac;
	private MockMvc mMvc;

	// rest api 를 호출할 Controller 의존설정
	@Autowired
	private RestStudyController restStudyController; 
	
	
	// 테스트 시작 전 실행해야할 함수 
	@Before
	public void setup() {
		this.mMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("mMvc setup : '{}'",this.mMvc);
	}

	// rest api 호출 URI 테스트(Get AllUser 모든 유저 조회하기)
//	@Test
	public void restGetTest() throws Exception {

		/*
		 해당 에러 : https://stackoverflow.com/questions/57305684/java-lang-assertionerror-response-content 로 해결
		mMvc.perform(get("/users"))
		.andExpect(status().isOk())
		.andExpect(content().string("{\"responseCode\":200, \"responseMsg\":\"success\"}"))
		.andDo(print());
		 */
		
		/*
			응답이 내부적으로 JSON형태로 변환되니 케이스를 string()대신 json()을 사용해야 한다.
			ObjectMapper를 사용해 객체 목록을 JSON 형태로 변환한다. 
		*/
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(restStudyController.getAllUsers());

		logger.info("result : '{}' ", result);

		mMvc.perform(MockMvcRequestBuilders
				.get("/users")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(result))
		.andDo(print());

	}
	
	// 특정 유저 조회 (아이디) get URI : /users/{userid}
//	@Test
	public void restGetUserIdTest() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(restStudyController.getUserByUserId("testid1")); // testid1 인 유저의 정보를 가져온다. 
		
		logger.info("result : '{}' ", result);
		
		mMvc.perform(MockMvcRequestBuilders.get("/users/testid1").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(result))
		.andDo(print());
		
	}
	
	// 유저 등록
//	@Test
	public void registerPostTest() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		
		User user = new User(6, "testName6", "testid6", "1234");
		mMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user)))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	// 유저 정보 수정
//	@Test
	public void modifyPutTest() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		User user = new User(5, "tttttest","testid5","1234");
		
		mMvc.perform(put("/users/testid5")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user)))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	// 유저 삭제 
	@Test
	public void deleteTest() throws Exception{
//		mMvc.perform(MockMvcRequestBuilders.delete("/users/testid1")) // true
		mMvc.perform(MockMvcRequestBuilders.delete("/users/testid7")) // false
		.andExpect(status().isOk())
		.andDo(print());
		
	}

}
