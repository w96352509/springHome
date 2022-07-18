package com.spring.core.session02.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.core.session02.beans.Author;

@Configuration
public class Authorconfig {

	@Bean(name = "authorJava")
	public Author getAuthor() {
		
		Author author = new Author();
		author.setName("Vic");
		author.setAge(18);
		author.setSex('m');
		return author;
	}
	
}
