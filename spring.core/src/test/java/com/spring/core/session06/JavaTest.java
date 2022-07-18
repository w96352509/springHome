package com.spring.core.session06;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.session06.entity.Emp;
import com.spring.core.session06.template.EmpDao;

public class JavaTest {

	@Test
	public void test() {
		
		List<Object[]> rows = new ArrayList<>();
		rows.add(new Object[]{"test03",3});
		rows.add(new Object[]{"test04",4});
		
		List<Emp> emps = new ArrayList<>();
		emps.add(new Emp("test05" , 5));
		emps.add(new Emp("test06" , 6));
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJDBCConfig.class);
		EmpDao empDao = ctx.getBean("empDao" , EmpDao.class);
		System.out.println(empDao.getById(1));
		empDao.queryAll3().stream().forEach(System.out::println);
		
	}
		
}
