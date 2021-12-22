package ssm.test;
import java.io.IOException;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hamcrest.Factory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ssm.mapper.UserMapper;
import ssm.pojo.Product;
import ssm.pojo.User;
public class TestMyBatis {
	private SqlSession sqlSession;
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void testBefore() throws IOException {
		InputStream input=Resources.getResourceAsStream("sqlMapConfig.xml");
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(input);
		sqlSession=sqlSessionFactory.openSession();
		}
	
	@Test
	public void selectAllUser() {
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> users=userMapper.selectAllUser();
		for(User user:users) {
			System.out.println(user);
		}
	}
	
	
	@After
	public void testAfter() {
		sqlSession.commit();
		sqlSession.close();
	}
	
}
