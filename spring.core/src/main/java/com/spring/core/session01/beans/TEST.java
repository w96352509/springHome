package com.spring.core.session01.beans;

class Anime {
	public void test() {
		System.out.println("我是動物");
	}
}

class Dog extends Anime{

	@Override
	public void test() {
		System.out.println("我是狗");
		
	}
	
}

public class TEST {

	public static void main(String[] args) {
		
		Anime a1 = new Dog();
		a1.test();
		
	}
	
}
