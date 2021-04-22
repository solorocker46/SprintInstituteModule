package com.cg.nsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nsa.entity.User;
import com.cg.nsa.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	private static int loginCheck = 0;

	@Autowired
	IUserRepository iRepository;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User user1 = iRepository.findByUserId(user.getUserId());
		if(user.getPassword().equals(user1.getPassword()) && user.getRole().equals(user1.getRole()))
		{
			return user;
		}
		return null;
	}

	@Override
	public User logout(User user) {
		// TODO Auto-generated method stub
		if(loginCheck == 1)
		{
			return user;
		}
		return null;
	}

}
