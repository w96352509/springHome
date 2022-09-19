package com.spring.core.session0828.lkp.sol;

import java.util.ArrayList;
import java.util.List;

import com.spring.core.session0828.lkp.Wallet;

// 送報生, 負責收款
public class PaperBoy {
	// 客戶
	private List<Customer> customers = null;

	public PaperBoy(List<Customer> customers) {
		this.customers = customers;
	}

	// 蒐集所有報紙費用
	
	public void collectMoney() {
		
		// 輪尋所有客戶
		for(Customer customer : customers) {
			customer.pay(100);

		}
	}
	
}
