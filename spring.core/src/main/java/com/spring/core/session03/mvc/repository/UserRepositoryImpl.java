package com.spring.core.session03.mvc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.core.session03.mvc.model.User;
import com.spring.core.session03.mvc.service.UserService;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	
	@Override
	public void repository(User user) {
		System.out.println("流程練習 - Repository" + user);
	}
}
