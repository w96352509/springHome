package com.spring.core.session02.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.core.session02.beans.Author;
import com.spring.core.session02.beans.Book;

@Configuration
public class BookConfig   {

	@Bean(name ="book")
	public Book getBook() {
		Book book     = new Book();
		Author author = new Author();
		author.setName("MM");
		author.setSex('m');
		author.setAge(29);
		book.setName("Java配置");
		book.setPrice(260);
		book.setAuthor(author);
		return book;
		
	}
}
