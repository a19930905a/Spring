package spring_jdbc.tx;

import java.util.List;

public interface BookShopService {
	//��{�ʶR
	public void purchase(String name,int id);
	//�M���ʶR
	public void multiplepurchase(String name,List<Integer> id);
}
