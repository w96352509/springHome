package com.spring.core.session03.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CarFactoryConfig {

	@Bean(name = "car2")
	public CarFactory carFactory()  {
		CarFactory carFactory = new CarFactory();
		System.out.println("工廠Java");
		return carFactory;
	}
	
}
