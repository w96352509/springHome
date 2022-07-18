package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Author;
import com.spring.core.session02.conf.Authorconfig;

public class AuthorTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Author author1 = ctx.getBean("author1" , Author.class);
		Author author2 = ctx.getBean("author2" , Author.class);
		Author author3 = ctx.getBean("author3" , Author.class);
		Author author4 = ctx.getBean("author4" , Author.class);
		System.out.println(author1);
		System.out.println(author2);
		System.out.println(author3);
		System.out.println(author4);
		
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(Authorconfig.class);
		Author authorJ = ctx2.getBean("authorJava" , Author.class);
		System.out.println(authorJ.toString());
	}
	
}
