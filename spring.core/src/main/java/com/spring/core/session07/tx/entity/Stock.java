package com.spring.core.session07.tx.entity;

public class Stock {

	private Integer sid;
	private Integer amount;
	private Integer bid;
	
	private Book book;

	
    public Stock() {
		
		
	}
	
	public Stock(Integer amount, Integer bid, Book book) {
		
		this.amount = amount;
		this.bid = bid;
		this.book = book;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Stock [sid=" + sid + ", amount=" + amount + ", bid=" + bid + ", book=" + book + "]";
	}

	
	
	
	
}
