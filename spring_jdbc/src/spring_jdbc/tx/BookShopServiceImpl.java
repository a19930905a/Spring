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
	
	//��{�ʶR
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void purchase(String name, int id) {
		//1.������y����
		int price = bookShopDao.findPrice(id);
		//2.��s�Ѯw�s
		bookShopDao.updateStock(id);
		//3.��s�Τ���]
		bookShopDao.updateAccount(name, price);
	}
	
	//�M���ʶR
	public void multiplepurchase(String name,List<Integer> id) {
		for(Integer i:id) {
			purchase(name, i);
		}	
	}

}
