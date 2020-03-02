package com.spring.ex02;

public class PersonServiceImpl1 implements PersonService1 {
	private String name;
	private int age;
	
	
	public PersonServiceImpl1(String name) {
		this.name = name;
	}
	
	public PersonServiceImpl1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	@Override
	public void sayHello() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}
