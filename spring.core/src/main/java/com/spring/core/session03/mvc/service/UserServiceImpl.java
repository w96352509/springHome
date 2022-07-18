package com.spring.core.session03.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.core.session03.mvc.controller.UserController;
import com.spring.core.session03.mvc.model.User;
import com.spring.core.session03.mvc.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void Service(User user) {
		System.out.println("流程練習 Service");
		userRepository.repository(user);
	}
}
