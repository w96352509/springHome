package com.spring.core.session02.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.spring.core.session02.beans.Author;

@Configuration
@ComponentScan
public class Authorconfig {

	@Bean
	public Author getAuthor() {
		Author author = new Author();
		author.setName("Vic");
		author.setAge(18);
		author.setSex('m');
		return author;
	}
	
}
