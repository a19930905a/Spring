package spring_jdbc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//查詢單一數據
	public user testQueryForOne(Integer id) {
		String sql="SELECT * from user where id = ?";
		BeanPropertyRowMapper<user> rowMapper=new BeanPropertyRowMapper<>(user.class);
		user u = jdbcTemplate.queryForObject(sql, rowMapper,id);
		
		return u;
	}
	//查詢特定資料庫範圍1
	public List<user> testQueryForList(Integer id) {
		String sql="SELECT * from user where id > ?";
		BeanPropertyRowMapper<user> rowMapper = new BeanPropertyRowMapper(user.class);
		List<user> user=jdbcTemplate.query(sql,rowMapper,id);
		
		return user;
	}
	//查詢特定資料庫範圍2
	public List<user> testQueryForList2(Integer id1,Integer id2) {
		String sql="SELECT * from user where id between ? and ? ";
		BeanPropertyRowMapper<user> rowMapper = new BeanPropertyRowMapper(user.class);
		List<user> user=jdbcTemplate.query(sql,rowMapper,id1,id2);
		
		return user;
	}
	//查詢數據庫資料量
	public long testQueryForObject() {
		String sql="SELECT count(id) from user";
		long count = jdbcTemplate.queryForObject(sql, long.class);
		
		return count;
	}
	//更新單筆
	public void testUpdate(String name,Integer sex,Integer age,Integer id) {
		String sql = "UPDATE user SET username = ? , sex = ? , age = ? WHERE id =?";
		jdbcTemplate.update(sql,name,sex,age,id);
		
	}
	//批量插入
	public void batchInsert(List<Object[]> list) {
		String sql = "INSERT into user(username,sex,age) values(?,?,?)";

		jdbcTemplate.batchUpdate(sql,list);
	}
}
