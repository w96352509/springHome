package com.spring.core.session07.tx.service;

import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

public interface BookService {
	void buyOne(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity;
	void addOne(String ename , Integer price);
	void addstock(Integer bid , Integer amount);
	void queryAll();
}
