package com.spring.core.session03;

import javax.xml.transform.Source;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session01.beans.HelloConfig;
import com.spring.core.session03.beans.Car;
import com.spring.core.session03.beans.CarFactoryConfig;

public class CarFactoryTest {

	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Car car = ctx.getBean("car", Car.class);
		car.setName("BMW");
		car.setPrice(10000);
		System.out.println(car);
		
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(CarFactoryConfig.class);
		Car car2 = ctx2.getBean("car2", Car.class);
		car2.setName("HH");
		System.out.println(car2);
		
	}
	
}
