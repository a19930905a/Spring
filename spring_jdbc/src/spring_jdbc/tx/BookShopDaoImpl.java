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
	
	//查尋書的價格
	@Override
	public Integer findPrice(Integer id) {
		String sql = "SELECT price FROM book_detail WHERE id = ?";

		return jdbcTemplate.queryForObject(sql,Integer.class,id);

	}
	
	//更新既有書籍數量
	@Override
	public void updateStock(Integer id) {
		String sql_check="SELECT stock FROM book_stock WHERE id=?";
		//檢查書籍數量是否不足
		int count =jdbcTemplate.queryForObject(sql_check,Integer.class,id);
		if(count==0) {
			throw new StockException("內存書籍不足");
		}
		
		String sql="UPDATE book_stock SET stock = stock -1 WHERE id = ?";

		jdbcTemplate.update(sql,id);
	}
	
	//更新用戶帳戶
	@Override
	public void updateAccount(String name, int price) {
		String sql_check="SELECT wallet FROM account WHERE name = ?";
		//檢查用戶錢包餘額
		int account=jdbcTemplate.queryForObject(sql_check,Integer.class,name);
		if(account<price) {
			throw new accountException("餘額不足!");
		}
		
		String sql = "Update account SET wallet = wallet - ? WHERE name = ?";

		jdbcTemplate.update(sql,price,name);
	}

}
