package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.mvc.controller.UserController;
import com.spring.core.session03.mvc.model.User;

public class UserMVCTest {

	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = ctx.getBean("user" , User.class); // 預設ID 首字小寫
		UserController userController = ctx.getBean("userController",UserController.class);
		userController.addUser(user);
		
	}
	
}
