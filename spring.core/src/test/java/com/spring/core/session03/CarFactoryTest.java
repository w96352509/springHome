package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Car;

public class CarFactoryTest {

	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Car car = ctx.getBean("car", Car.class);
		System.out.println(car);
	}
	
}
