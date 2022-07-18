package com.spring.core.session07.tx.entity;

import java.util.Date;

public class Book {

	private Integer bid;
	private String  bname;
	private Integer price;
	private Date ct;
	
	// 關聯關係
	private Stock stock;
	
    public Book() {
		
	}
	
	public Book(String bname, Integer price) {
		
		this.bname = bname;
		this.price = price;
		
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getCt() {
		return ct;
	}

	public void setCt(Date ct) {
		this.ct = ct;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", price=" + price + ", ct=" + ct + ", stock=" + stock + "]";
	}

	

	
	
	
	
	
}
