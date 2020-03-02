package com.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest1 {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		
		PersonService1 person1 = (PersonService1)factory.getBean("personService1");
		person1.sayHello();
		
		PersonService1 person2 = (PersonService1)factory.getBean("personService2");
		person2.sayHello();
	}
}
