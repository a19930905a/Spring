package spring_jdbc.test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;





class JDBCTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private UserDao userdao;
	{
		ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		userdao=ctx.getBean(UserDao.class);
	}
	/**
	 * 
	 *  使用 Dao 測試
	 * 
	 * */
	
	@Test
	public void testDao() {
		//System.out.println(userdao.testQueryForOne(1));
		//System.out.println(userdao.testQueryForList(8));
		//System.out.println(userdao.testQueryForObject());
		//userdao.testUpdate("letme", 1, 14, 2);
		
		/*
		List<Object[]> list=new ArrayList();
		list.add(new Object[] {"meme",2,5});
		list.add(new Object[] {"like",2,15});
		list.add(new Object[] {"java",2,18});
		
		userdao.batchInsert(list);
		*/
		
		System.out.println(userdao.testQueryForList2(5, 7));
	}
	
	
	
	/**
	 * 
	 *    執行 insert , update , delete
	 * 
	 */
	//批量插入
	@Test
	public void batchInsert() {
		String sql = "INSERT into user(username,sex,age) values(?,?,?)";
		
		List<Object[]> list = new ArrayList();
		
		list.add(new Object[] {"8+9",2,22});
		list.add(new Object[] {"hehe",1,23});
		list.add(new Object[] {"jack",1,24});
		
		jdbcTemplate.batchUpdate(sql,list);
	}
	
	//更新單條數據
	@Test
	public void testUpdate() {
		String sql = "UPDATE user SET username = ? , sex = ? , age = ? WHERE id =?";
		jdbcTemplate.update(sql, "87bin",1,24,5);
		
	}
	
	//查看數據庫內的數據量
	@Test
	public void testQueryForObject() {
		String sql="SELECT count(id) from user";
		
		long count = jdbcTemplate.queryForObject(sql, long.class);
		System.out.println(count);
		
	}
	
	//查看多條數據
	@Test
	public void testQueryForList() {
		String sql="SELECT * from user where id between ? and ?";
		BeanPropertyRowMapper<user> rowMapper = new BeanPropertyRowMapper(user.class);
		List<user> user=jdbcTemplate.query(sql, rowMapper, 6 ,8);
		
		System.out.println(user);
	}
	
	//查看單條數據
	@Test
	public void testQueryForOne() {
		String sql="SELECT * from user where id = ?";
		BeanPropertyRowMapper<user> rowMapper=new BeanPropertyRowMapper<>(user.class);
		user u = jdbcTemplate.queryForObject(sql, rowMapper,1);
		
		System.out.println(u);
	}
	
	//測試連線
	@Test
	public void test() throws SQLException {
		DataSource dataSource=ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
