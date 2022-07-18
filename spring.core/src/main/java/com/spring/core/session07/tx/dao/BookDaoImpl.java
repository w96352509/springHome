package com.spring.core.session07.tx.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.core.session07.tx.entity.Book;
import com.spring.core.session07.tx.entity.Stock;
import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;


@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Integer getPrice(Integer bid) {
		String sql = "select price from book where bid=? ";
		return jdbcTemplate.queryForObject(sql, Integer.class , bid);
	}

	@Override
	public Integer getStockAmount(Integer bid) {
		String sql = "select amount from stock  where bid = ? ";
		return jdbcTemplate.queryForObject(sql, Integer.class , bid);
	}

	@Override
	public Integer getWalletMoney(Integer wid) {
		String sql = "select money from wallet where wid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class , wid);
	}

	@Override
	public Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity {
		// 確認目前庫存
		Integer new_amount = getStockAmount(bid);
		if(new_amount <= 0) {
			throw new InsufficientQuantity(String.format("此書號:%d 庫存不足, 目前數量:%d", bid, new_amount));
		}else if(new_amount < amount) {
			throw new InsufficientQuantity(String.format("此書號:%d 庫存不足, 目前數量:%d 欲購買數量:%d", bid, new_amount, amount));
		}
		// 修改庫存
		String sql = "update stock set amount = amount - ? where bid=? ";
		return jdbcTemplate.update(sql,amount,bid);
	}

	@Override
	public Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount {
		Integer new_money = getWalletMoney(wid);
		if(new_money <=0) {
			throw new InsufficientAmount(String.format("錢包號碼 : %d 餘額為0 , 目前餘額 : %d" , wid , money));
		}else if (new_money < money) {
			throw new InsufficientAmount(String.format("錢包號碼：%d 餘額不足，目前餘額：$ %d，欲扣款金額：$ %d", wid, new_money, money));
		}
		String sql = "update wallet set money = money - ? where wid =?";
	    return jdbcTemplate.update(sql, money , wid);
	}

	@Override
	public Integer addBook(String bname, Integer price ) {
		String sql = "insert into book(bname , price) value(?,?)";
		return jdbcTemplate.update(sql, bname , price);
	}
	
	@Override
	public Integer addStock(Integer bid, Integer amount) {
		String sql = "insert into stock(bid , amount) value(?,?)";
		return jdbcTemplate.update(sql, bid , amount);
	}
	
	@Override
	public List<Integer> getSize() {
		String sql ="select bid from stock";
		RowMapper<Integer> rowMapper = (ResultSet rs, int rowNum)->{
			Stock stock = new Stock();
			stock.setBid(rs.getInt("bid"));
			return stock.getBid();
		};
		return jdbcTemplate.query(sql,rowMapper);
	}
	

	@Override
	public String getName(Integer bid) {
		String sql = "select bname from book where bid=?";
		return jdbcTemplate.queryForObject(sql,String.class,bid);
	}

	

	@Override
	public List<Book> queryAll() {
		String sql = "select bid , bname , price , ct from book";
		List<Book> books = null;
		books = jdbcTemplate.query(sql, (ResultSet rs, int rowNum)->{
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setBname(rs.getString("bname"));
			book.setPrice(rs.getInt("price"));
			book.setCt(rs.getDate("ct"));
			
			String sql2 ="select sid,bid,amount from stock where bid=?";
			Stock stock = jdbcTemplate.queryForObject(sql2, new BeanPropertyRowMapper<Stock>(Stock.class), book.getBid());
			book.setStock(stock);
			
			return book;
		});
		return books;
	}

	@Override
	public Integer update(Integer bid, Integer amount) {
		String sql = "update stock set amount = ? where bid = ? ";
		return jdbcTemplate.update(sql , amount , bid);
	}

	

	

	

	
	
}
