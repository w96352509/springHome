package com.spring.core.session07.tx.service;

import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

public interface BookService {
	void buyOne() throws InsufficientAmount, InsufficientQuantity;
	void addOne();
	void addWallet();
	void queryAll();
	void updateStock();
}
