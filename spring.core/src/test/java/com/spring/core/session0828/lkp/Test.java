package com.spring.core.session0828.lkp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.spring.core.session0828.lkp.sol.Customer;
import com.spring.core.session0828.lkp.sol.PaperBoy;


public class Test {

	public static void main(String[] args) {

		List<Customer> customers = Arrays.asList(
				new Customer(new Wallet("1" , 1000)),
				new Customer(new Wallet("2" , 500)),
				new Customer(new Wallet("3" , 250))
				);
		
	    PaperBoy paperBoy = new PaperBoy(customers);
	    paperBoy.collectMoney();
	    System.out.println(customers);
		
		
	}
}
