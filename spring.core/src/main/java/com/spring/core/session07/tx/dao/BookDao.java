package com.spring.core.session07.tx.dao;

import java.util.List;

import com.spring.core.session07.tx.entity.Book;
import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

public interface BookDao {

	Integer getPrice(Integer bid); // 根據 bid 取得書本價格
	String  getName(Integer bid); // 根據 bid 取得書本價格
	Integer getStockAmount(Integer bid);  // 根據 bid 取得庫存數量
	Integer getWalletMoney(Integer wid);  // 根據 wid 取得可用餘額
	Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity; // 減去庫存
	Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount; // 減去餘額
	Integer update(Integer bid, Integer amount); // 減去庫存
	Integer addBook(String bname , Integer price);
	Integer addStock(Integer bid , Integer amount); 
	List<Integer> getSize();
	List<Book> queryAll();
}
