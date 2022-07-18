package com.spring.core.session01.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

	@Bean(name = "hello")
	public Hello getHello() {
		Hello hello = new Hello();
		return hello;
	}
	
}
