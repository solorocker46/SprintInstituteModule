package com.cg.nsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nsa.entity.User;
import com.cg.nsa.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService service;
	
	@GetMapping("/login")
	public ResponseEntity<Object> login(@RequestBody User user)
	{
		service.login(user);
		return new ResponseEntity<Object>("Login successful", HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<Object> logout(@RequestBody User user)
	{
		service.logout(user);
		return new ResponseEntity<Object>("Logout successful", HttpStatus.OK);
	}
}
