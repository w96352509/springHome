package com.spring.core.session01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session01.beans.Hello;
import com.spring.core.session01.beans.HelloConfig;

public class HelloTest {

	@Test
	public void Test() {
		
		// xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello hello = ctx.getBean("hello" , Hello.class);
		System.out.println(hello.toString());
		
		// Java 配置
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(HelloConfig.class);
		Hello hello2 = ctx2.getBean("hello" , Hello.class);
		System.out.println(hello2.toString());
		
	}
	
}
