package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Paper;
import com.spring.core.session02.beans.WhiteA4;

public class PaperTest {

	@Test
	public void Test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Paper paper1 =   ctx.getBean("paper1" , Paper.class);
		WhiteA4 paper2 = ctx.getBean("paper2" , WhiteA4.class);
		System.out.println(paper1);
		System.out.println(paper2);
		
	}
	
}
