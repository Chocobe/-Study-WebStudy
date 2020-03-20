package com.spring.ex01;

import static java.lang.System.out;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AOPTest.xml");
		Calculator cal = (Calculator)context.getBean("proxyCal");
		
		cal.add(100, 20);
		out.println();
		
		cal.subtract(100, 20);
		out.println();
		
		cal.multiply(100, 20);
		out.println();
		
		cal.divide(100, 20);
	}
}
