package com.spring.core.session07.tx.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.core.session07.tx.dao.BookDao;
import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

@Service
public class ManyBookServiceImpl implements ManyBookService {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookDao bookDao;
	
	@Transactional(rollbackFor = {InsufficientAmount.class , InsufficientQuantity.class})
	@Override
	public void buyMany() throws InsufficientAmount, InsufficientQuantity {
		
		System.out.println("輸入購買書本ID :");
		Scanner scanner = new Scanner(System.in);
		String bidss  = scanner.nextLine();
		String[] bids = bidss.trim().split(" ");
		System.out.println("輸入錢包ID:");
		Integer wid = scanner.nextInt();
		for(String bid : bids) {
			bookDao.updateStock(Integer.parseInt(bid), 1);
			bookDao.updateWallet(wid, bookDao.getPrice(Integer.parseInt(bid)));
		}
		System.out.println("購買多筆");
 	}

}
