package spring_jdbc.tx;

public interface BookShopDao {

	//�j�M�Ѫ�����
	public Integer findPrice(Integer id);
	//��s�J�����y�ƶq
	public void updateStock(Integer id);
	//��s�Τ�b��
	public void updateAccount(String name,int price);
}
