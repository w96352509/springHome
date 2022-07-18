package com.spring.core.session02.beans;

import java.util.Random;

public class Lotto {

	private int number;
	
	public Lotto() {
		System.out.println("建立Lotto物件");
		Random r = new Random();
		number = r.nextInt(100) + 1;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Lotto [number=" + number + "]";
	}

}
