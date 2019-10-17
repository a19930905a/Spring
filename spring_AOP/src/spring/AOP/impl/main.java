package spring.AOP.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("bean-aop.xml");
		
		calculator c =ac.getBean(calculator.class);
		int res = c.add(1, 2);
		System.out.println(res);
	
	}

}
