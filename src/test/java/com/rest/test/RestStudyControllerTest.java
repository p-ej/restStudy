package com.rest.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.context.annotation.Bean;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class RestStudyControllerTest {
	/*
	 * RestStudyController의 요청응답을 테스트할 컨트롤러 
	 */
	private static final Logger logger = LoggerFactory.getLogger(RestStudyControllerTest.class);

	@Inject
	private WebApplicationContext wac;
	private MockMvc mMvc;

	// rest api 를 호출할 Controller 의존설정
	@Autowired
	private RestStudyController restStudyController; 
	
	
	@Before
	public void setup() {
		this.mMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
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
	@Test
	public void registerPost() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
//		String result = mapper.writeValueAsString(restStudyController.registerUser(new User(6,"testName6","testid6","1234")));
		
//		logger.info("result : '{}' ", result);
		
		User user = new User(6, "testName6", "testid6", "1234");
		mMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user)))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	// 유저 정보 수정
	
	
	// 유저 삭제 
	

}