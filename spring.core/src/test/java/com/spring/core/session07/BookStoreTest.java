package com.spring.core.session07;

import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session07.tx.controller.BookController;
import com.spring.core.session07.tx.dao.BookDao;

public class BookStoreTest {

	private boolean stop;
	
	@Test
	public void  test() { 
		new BookStoreTest().start();
	}

	private void menu() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController controller = ctx.getBean(BookController.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		System.out.println("-------歡迎進入圖書商店系統--------");
		System.out.println("請根據提示選擇:");
		System.out.println(" 1.增加圖書\t\t 2.更新圖書數量\t\t 3.購買圖書\n 4.全搜尋圖書\t\t 5.新增錢包\n " + "0.退出系統");
		System.out.println("請輸入:");
		Scanner scanner = new Scanner(System.in);
		Integer choice = scanner.nextInt();
		switch (choice) {
		case 1:
            controller.addBook();
			break;
		case 2:
            controller.updateStock();
			break;
		case 3:
            System.out.println("單筆購買輸入偶數 , 多筆購買輸入奇數");
            Integer num1 = scanner.nextInt();
            if(num1 % 2 ==0) {
            	controller.buyBook();
            	return;
            }
               System.out.println("輸入格式: wid bid bid...");
               controller.buyBooks();
			break;
		case 4:
            controller.queryAll();
			break;
		case 5:

			break;
		case 0:
			System.out.println("離開系統");
			stop = true;
			break;
		}
	}

	private void start() {
       while (!stop) {
		 menu();
	   }
	}
}
