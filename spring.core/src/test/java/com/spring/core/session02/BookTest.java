package com.spring.core.session02;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Author;
import com.spring.core.session02.beans.Book;
import com.spring.core.session02.conf.Authorconfig;
import com.spring.core.session02.conf.BookConfig;

public class BookTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Book[] books = {
				ctx.getBean("book1" , Book.class),
				ctx.getBean("book2" , Book.class),
				ctx.getBean("book3" , Book.class)
		};
		Arrays.stream(books).forEach(System.out::println);
		
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(BookConfig.class);
		Book book = ctx2.getBean("book" , Book.class);
		System.out.println(book);
	}
	
}
