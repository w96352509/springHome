package com.spring.core.session03.beans;

public class BeanCycle {

	public void init() {
		System.out.println("開始");
	}
	
	public void query() {
		System.out.println("查詢");
	}
	
	public void destory() {
		System.out.println("關閉");
	}
	
}
