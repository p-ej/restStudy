package com.rest.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.test.service.UserService;

@RestController
@RequestMapping("/user")
public class RestSturdyController {
	
	@Autowired
	private UserService serivce;
}	
