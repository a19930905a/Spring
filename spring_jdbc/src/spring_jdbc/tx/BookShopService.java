package spring_jdbc.tx;

import java.util.List;

public interface BookShopService {
	//實現購買
	public void purchase(String name,int id);
	//清單購買
	public void multiplepurchase(String name,List<Integer> id);
}
