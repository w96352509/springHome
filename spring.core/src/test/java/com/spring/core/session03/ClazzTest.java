package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Clazz;
import com.spring.core.session03.beans.Student;
import com.spring.core.session03.beans.Teacher;

public class ClazzTest {

	@Test
	public void Test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Teacher teacher1 = ctx.getBean("teacher1",Teacher.class);
		System.out.println(teacher1);
		
		Teacher teacher2 = ctx.getBean("teacher2",Teacher.class);
		System.out.println(teacher2);
		
		// teacher1的學生平均分
		teacher1.getStudents()
		.stream()
		.mapToDouble(s->s.getClazzs().stream()
		.mapToInt(Clazz::getCredit)
		.average()
		.getAsDouble())
		.forEach(System.out::println);
		
		
	}
	
}
