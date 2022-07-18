package com.spring.core.session04.sta;

public class ProxyPerson implements Person {

	// 代理對象
	private Person person;
	
	
	
	public ProxyPerson(Person person) {
		this.person = person;
	}

    @Override
	public void work() {
		System.out.println("戴口罩");
		person.work();
    }

}
