package com.spring.core.session01;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session01.beans.Hello;
import com.spring.core.session01.beans.HelloConfig;
import com.spring.core.session01.beans.Message;
import com.spring.core.session01.beans.User;

public class HelloTest {

	@Test
	public void Test() {
		
		// xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		Hello hello = ctx.getBean("hello" , Hello.class);
		System.out.println(hello.toString());
		System.out.println(ctx.getApplicationName());
		
		// Java 配置
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(HelloConfig.class);
		Hello hello2 = ctx2.getBean("hello" , Hello.class);
		System.out.println(hello2.toString()+"123");
		
		ApplicationContext ctx3 = new AnnotationConfigApplicationContext(Message.class);
		Message message = ctx3.getBean(Message.class);
		message.message();
		
		AnnotationConfigApplicationContext ctx4 = new AnnotationConfigApplicationContext(User.class);
		User user = ctx4.getBean(User.class);
		user.line();
		ctx4.getBeanDefinitionNames();
		for(String s : ctx3.getBeanDefinitionNames()) {
			System.out.println(s);
		}
	}
	
}
