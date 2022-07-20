package com.spring.core.session07.tx.dao;

import java.util.List;

import com.spring.core.session07.tx.entity.Book;
import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

public interface BookDao {

	Integer getPrice(Integer bid); // 根據 bid 取得書本價格
	String  getName(Integer bid);  // 根據 bid 取得書本價格
	Integer getStockAmount(Integer bid);  // 根據 bid 取得庫存數量
	Integer getWalletMoney(Integer wid);  // 根據 wid 取得可用餘額
	Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity; // 減去庫存
	Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount; // 減去餘額
	Integer update(Integer bid, Integer amount);    // 更新庫存
	Integer addBook(String bname , Integer price);  // 新增書本
	Integer addStock(Integer bid , Integer amount); // 新增庫存
	Integer addWallt(String ename , Integer money); // 新增錢包
	Integer getByBname(String bname);               // 用 bname 搜尋 bid
	List<Integer> getSize();                        // 所有書的代號
	List<Book> queryAll();                          // 全搜尋
	
}
