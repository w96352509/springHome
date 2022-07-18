package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Lotto;
import com.spring.core.session02.conf.Lottoconfig;

public class LottoTest {

	@Test
	public void Test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Lotto lotto = ctx.getBean("lotto" , Lotto.class);
		Lotto lottoPrototype = ctx.getBean("lotto2" , Lotto.class);
		System.out.println(lotto.toString());
		System.out.println(lottoPrototype.toString());
		
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(Lottoconfig.class);
		Lotto lotto2 = ctx2.getBean("lotto" , Lotto.class);
		System.out.println(lotto2.toString());
	}
	
}
