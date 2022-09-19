package com.spring.core.session0828.lkp.before;

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
			// 先拿取客戶皮包
			Wallet wallet = customer.getWallet();
			// 得到錢
			int total = wallet.getMoney();
			// -100
			total = total - 100;
			// 再將剩餘的錢放回皮包
			wallet.setMoney(total);
			// 不應該去拿到客戶ID , 應送報生權力太大
			wallet.getId();
			System.out.println("ID" + wallet.getId() + ":" + wallet.getMoney());
		}
	}
	
}
