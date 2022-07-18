package com.spring.core.session04;

import org.junit.Test;

import com.spring.core.session04.cglib.EchancerHello;
import com.spring.core.session04.cglib.Hello;

public class EchancerHelloTest {

	@Test
	public void test() {
	
		Hello hello = new EchancerHello();
		System.out.println(hello.sayHello("John"));
		
	}
	
}
