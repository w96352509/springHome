package com.spring.core.session0828.lkp;

public class Wallet {

	private String id;
	private int money;
	
	public Wallet() {
		
	}
	
	public Wallet(String id, int money) {
		this.id = id;
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Wallet [id=" + id + ", money=" + money + "]";
	}
	
	
}
