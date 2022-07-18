package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.BeanCycle;

public class CycleTest {

	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanCycle cycle = ctx.getBean("cycle1",BeanCycle.class);
		cycle.query();
		((ClassPathXmlApplicationContext)ctx).close();
		
	}
	
}
