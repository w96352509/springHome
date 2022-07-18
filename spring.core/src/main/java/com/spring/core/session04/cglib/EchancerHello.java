package com.spring.core.session04.cglib;

public class EchancerHello extends Hello {

	@Override
	public String sayHello(String str) {
		String message = "請出示實聯";
		return super.sayHello(str) + message;
	}

}
