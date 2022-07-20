package com.spring.core.session07.tx.service;

import java.util.Iterator;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.core.session07.tx.dao.BookDao;
import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { InsufficientAmount.class,
			InsufficientQuantity.class })
	@Override
	public void buyOne() throws InsufficientAmount, InsufficientQuantity {
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入購買書本 :");
		String bname  = scanner.next();
		Integer bid = bookDao.getByBname(bname);
		bookDao.updateStock(bid, 1);
		System.out.println("輸入錢包ID:");
		Integer wid = scanner.nextInt();
		Integer price = bookDao.getPrice(bid);
		bookDao.updateWallet(wid, price);
	}

	@Override
	public void addOne() {
		System.out.println("新增書本");
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入書本名稱:");
		String ename  = scanner.next();
		System.out.println("OK");
		System.out.println("輸入書本價格:");
		Integer price  = scanner.nextInt();
		bookDao.addBook(ename, price);
		System.out.println("OK");
		System.out.println("輸入數量");
		Integer bid = bookDao.getByBname(ename);
		Integer amount  = scanner.nextInt();
	    bookDao.addStock(bid, amount);
		System.out.println("新增OK");
	}

	@Override
	public void queryAll() {
		bookDao.queryAll().stream().forEach(System.out::println);
		
	}

	@Override
	public void addWallet() {
		System.out.println("新增錢包");
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入錢包名稱:");
		String wname = scanner.next();
		System.out.println("OK");
		System.out.println("輸入儲值金額:");
		Integer money = scanner.nextInt();
		System.out.println("OK");
		bookDao.addWallt(wname, money);
		System.out.println("新增錢包成功");
	}

	@Override
	public void updateStock() {
		System.out.println("更新書本庫存");
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入書名:");
		String bname = scanner.next();
		Integer bid = bookDao.getByBname(bname);
		Integer amount_now = bookDao.getStockAmount(bid);
		System.out.println("目前數量:" + amount_now);
		System.out.println("輸入修改數量:");
		Integer amount = scanner.nextInt();
		bookDao.update(bid, amount);
		System.out.println("更新成功");
	}
}
