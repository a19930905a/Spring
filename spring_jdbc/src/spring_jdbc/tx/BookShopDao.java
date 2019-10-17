package spring_jdbc.tx;

public interface BookShopDao {

	//搜尋書的價格
	public Integer findPrice(Integer id);
	//更新既有書籍數量
	public void updateStock(Integer id);
	//更新用戶帳戶
	public void updateAccount(String name,int price);
}
