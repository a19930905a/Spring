package spring.beans.relations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.beans.autowire.Person;

public class main {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-relations.xml");
		
		Person p = ac.getBean(Person.class);
		System.out.println(p);
	}

}
