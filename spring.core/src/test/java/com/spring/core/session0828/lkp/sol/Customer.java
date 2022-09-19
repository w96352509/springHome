package com.spring.core.session0828.lkp.sol;

import com.spring.core.session0828.lkp.Wallet;

public class Customer {

	private Wallet wallet;

	public Customer(Wallet wallet) {
		this.wallet = wallet;
	}

	// 請求付款
	// 要做自己做
	public void pay(int payment) {
		int total = wallet.getMoney();
		total = total - payment;
		wallet.setMoney(total);
	}


	@Override
	public String toString() {
		return "Customer [wallet=" + wallet + "]";
	}
}
