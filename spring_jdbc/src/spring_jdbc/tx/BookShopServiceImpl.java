package spring_jdbc.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	
	//實現購買
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void purchase(String name, int id) {
		//1.獲取書籍價格
		int price = bookShopDao.findPrice(id);
		//2.更新書庫存
		bookShopDao.updateStock(id);
		//3.更新用戶錢包
		bookShopDao.updateAccount(name, price);
	}
	
	//清單購買
	public void multiplepurchase(String name,List<Integer> id) {
		for(Integer i:id) {
			purchase(name, i);
		}	
	}

}
