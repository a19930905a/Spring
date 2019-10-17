package spring.beans.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.beans.autowire.Car;
import spring.beans.autowire.Person;

public class main {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-scope.xml");
		
		Car c1 = ac.getBean(Car.class);
		Car c2 = ac.getBean(Car.class);
		System.out.println(c1==c2);
	}

}
