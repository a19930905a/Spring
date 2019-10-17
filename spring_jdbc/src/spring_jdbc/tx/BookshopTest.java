package spring_jdbc.tx;



import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class BookshopTest {

	ApplicationContext ctx=null;
	BookShopDao bookShopDao=null;
	BookShopService bookShopService=null;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopDao=ctx.getBean(BookShopDao.class);
		bookShopService=ctx.getBean(BookShopService.class);
	}
	
	@Test
	public void testBookshop() {
		bookShopService.multiplepurchase("Alan", Arrays.asList(1001,1002));
		
	}

}
