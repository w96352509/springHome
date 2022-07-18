package com.spring.core.session02.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.spring.core.session02.beans.Lotto;

@Configuration
public class Lottoconfig {

	@Bean(name = "lotto")
	@Scope("prototype")
	public Lotto getLotto() {
		System.out.println("Java 配置");
		Lotto lotto = new Lotto();
		return lotto;
	}
	
}
