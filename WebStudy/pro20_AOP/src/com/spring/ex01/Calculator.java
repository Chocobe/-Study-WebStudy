package com.spring.ex01;

import static java.lang.System.out;

public class Calculator {
	public void add(int x, int y) {
		int result = x + y;
		out.println("결과 : " + result);
	}
	
	
	public void subtract(int x, int y) {
		int result = x - y;
		out.println("결과 : " + result);
	}
	
	
	public void multiply(int x, int y) {
		int result = x * y;
		out.println("결과 : " + result);
	}
	
	
	public void divide(int x, int y) {
		int result = x / y;
		out.println("결과 : " + result);
	}
}
