package com.cg.nsa.service;

import org.springframework.stereotype.Service;

import com.cg.nsa.entity.User;

@Service
public interface IUserService {

	User login(User user);
	
	User logout(User user);
}
