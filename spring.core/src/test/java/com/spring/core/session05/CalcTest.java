package com.spring.core.session05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session05.aop.MathCalc;
import com.spring.core.session05.aop.MathCalcImpl;

public class CalcTest {

	@Test
	public void test() {
		
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(AOPConfig.class);
		MathCalc calc2 = ctx2.getBean(MathCalc.class);
		System.out.println(calc2.add(20, 10));
		System.out.println(calc2.div(20, 10));
		
	}
	
}
