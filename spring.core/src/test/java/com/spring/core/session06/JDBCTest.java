package com.spring.core.session06;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.core.session06.template.EmpDao;

public class JDBCTest {

	@Test
	public void test() {
		
		// Xml 配置 
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
	    EmpDao empDao = ctx.getBean("empDao" , EmpDao.class);
	    System.out.println(empDao.queryAll3());
	    
	}
	
}
