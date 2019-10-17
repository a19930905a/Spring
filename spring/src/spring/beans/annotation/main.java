package spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.beans.annotation.controller.UserController;

public class main {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-annotation.xml");
		
		UserController userController = (UserController) ac.getBean("userController");
		
		System.out.println(userController);
		userController.execute();
	}

}
