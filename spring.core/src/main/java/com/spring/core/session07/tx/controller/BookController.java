package com.spring.core.session07.tx.controller;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;
import com.spring.core.session07.tx.service.BookService;
import com.spring.core.session07.tx.service.ManyBookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ManyBookService manyBookService;
	
	// 單筆購買
	public void buyBook() {
		try {
			bookService.buyOne();
			System.out.println("購買單筆");
		} catch (InsufficientAmount e) {
			e.printStackTrace();
			System.out.println("庫存不足:" + e);
		} catch(InsufficientQuantity e) {
			e.printStackTrace();
			System.out.println("金額不足:" + e);
		}
	}
	
	// 多筆購買
	public void buyBooks() {
		try {
			manyBookService.buyMany();
		} catch (InsufficientAmount e) {
			e.printStackTrace();
			System.out.println("庫存不足 :" + e);
		} catch (InsufficientQuantity e) {
			e.printStackTrace();
			System.out.println("金額不足 :" + e);
		}
	}
	
	// 新增書和庫存
	public void addBook() {
		bookService.addOne();
	}
	
	// 全搜尋
	public void queryAll() {
		System.out.println("查詢結果:");
		bookService.queryAll();
	}
	
	// 指定 bid 新增
	public void updateStock() {
		bookService.updateStock();
	}
	
	// 新增錢包
	public void addWallet() {
		bookService.addWallet();
	}
}
