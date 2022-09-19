package com.spring.core.session0828.lkp.before;

import com.spring.core.session0828.lkp.Wallet;

public class Customer {

	private Wallet wallet;

	public Customer(Wallet wallet) {
		this.wallet = wallet;
	}

	// 讓外界可以得到 wallet
	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "Customer [wallet=" + wallet + "]";
	}
}
