package spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {
		/*
		HelloWorld hw = new HelloWorld();
		hw.setName("Alan");
		*/
		
		//1.創建Spring IOC 容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//HelloWorld hw = (HelloWorld)ctx.getBean("helloWorld");
		
		//hw.hello();
		
		//Car car = ctx.getBean(Car.class);
		//System.out.println(car);
		
		Person p = ctx.getBean(Person.class);
		System.out.println(p);
		
	}

}
