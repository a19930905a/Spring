package spring_jdbc.tx;

import javax.management.RuntimeErrorException;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//�d�M�Ѫ�����
	@Override
	public Integer findPrice(Integer id) {
		String sql = "SELECT price FROM book_detail WHERE id = ?";

		return jdbcTemplate.queryForObject(sql,Integer.class,id);

	}
	
	//��s�J�����y�ƶq
	@Override
	public void updateStock(Integer id) {
		String sql_check="SELECT stock FROM book_stock WHERE id=?";
		//�ˬd���y�ƶq�O�_����
		int count =jdbcTemplate.queryForObject(sql_check,Integer.class,id);
		if(count==0) {
			throw new StockException("���s���y����");
		}
		
		String sql="UPDATE book_stock SET stock = stock -1 WHERE id = ?";

		jdbcTemplate.update(sql,id);
	}
	
	//��s�Τ�b��
	@Override
	public void updateAccount(String name, int price) {
		String sql_check="SELECT wallet FROM account WHERE name = ?";
		//�ˬd�Τ���]�l�B
		int account=jdbcTemplate.queryForObject(sql_check,Integer.class,name);
		if(account<price) {
			throw new accountException("�l�B����!");
		}
		
		String sql = "Update account SET wallet = wallet - ? WHERE name = ?";

		jdbcTemplate.update(sql,price,name);
	}

}
