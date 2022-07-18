package com.spring.core.session07.tx.service;

import java.util.Iterator;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.core.session07.tx.dao.BookDao;
import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public void buyOne(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity {
		bookDao.updateStock(bid, 1);
		Integer price = bookDao.getPrice(bid);
		bookDao.updateWallet(wid, price);
		System.out.println("購買書本名稱" + bookDao.getName(bid));
		System.out.println("購買書本價格" + bookDao.getPrice(bid));
		System.out.println("錢包剩餘:" + bookDao.getWalletMoney(wid));
		System.out.println("書本庫存:" + bookDao.getStockAmount(bid));
	}

	@Override
	public void addOne(String ename, Integer price) {
		System.out.println("新增書本");
		bookDao.addBook(ename, price);
		System.out.println("新增成功");
	}

	@Override
	public void queryAll() {
		bookDao.queryAll().stream().forEach(System.out::println);
		;
	}

	@Override
	public void addstock(Integer bid, Integer amount) {
		// 提醒已擁有 stock 的 book
		if (bookDao.getSize().contains(bid) == true) {
			System.out.println("已擁有庫存");
			System.out.println(bookDao.getSize().contains(bid));
			return;
		}
		System.out.println("新增庫存");
		bookDao.addStock(bid, amount);
	}
}
