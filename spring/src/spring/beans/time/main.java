package spring.beans.time;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans-time.xml");
		
		Car car = (Car) ac.getBean("car");
		System.out.println(car);
		
		//close
		
		ac.close();
	}

}
