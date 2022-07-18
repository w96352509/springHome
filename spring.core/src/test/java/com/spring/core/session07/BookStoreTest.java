package com.spring.core.session07;

import java.util.Iterator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session07.tx.controller.BookController;
import com.spring.core.session07.tx.dao.BookDao;

public class BookStoreTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController controller = ctx.getBean(BookController.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		controller.buyBooks(1,1,2);
		// 更新介面並增加 tx在購買書部分
		
	}
	
}
