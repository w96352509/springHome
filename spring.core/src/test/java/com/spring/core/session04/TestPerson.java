package com.spring.core.session04;

import org.junit.Test;

import com.spring.core.session04.sta.Man;
import com.spring.core.session04.sta.Person;
import com.spring.core.session04.sta.ProxyPerson;

public class TestPerson {

	@Test
	public void test() {
		
		Person person = new ProxyPerson(new Man());
		person.work();
		
	}
	
}
