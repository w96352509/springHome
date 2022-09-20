package com.spring.core.session01.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class Message {

	private String line;
	
	// 會調用方法
	@Autowired
	public void message() {
		System.out.println(123);
	}
	
}


