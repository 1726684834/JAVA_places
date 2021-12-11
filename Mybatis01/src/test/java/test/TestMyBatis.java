package test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ssm.mapper.ProductMapper;
import ssm.pojo.Car;
import ssm.pojo.Product;
public class TestMyBatis {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	@Before
	public void testBefore() throws IOException {
		InputStream input=Resources.getResourceAsStream("sqlMapConfig.xml");
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(input);
		sqlSession=sqlSessionFactory.openSession();
	}
	
	@Test
	public void  testSelectAll() {
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<Product> products=productMapper.selectAll();
		for(Product p:products) {
			System.out.println(p);
		}

	}
	
	@Test
	public void  testSelectById() {
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<Product> product=productMapper.selectById(2);
		System.out.println(product);

	}
	@Test
	public void  testSelectLikeName() {
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<Product> product=productMapper.selectLikeName("CPU1");
		System.out.println(product);

	}
	
	@Test
	public void testSaveOne() {
		Product product=new Product(null,"C_1","CPU",100,12.4f);
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		int res=productMapper.saveOne(product);
		System.out.println(res);
	}
	@Test
	public void testDeleteById() {
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		int res=productMapper.deleteById(10);
		System.out.println(res);
	}
	@Test
	public void testUpdateById() {
		Product product=new Product(6,"C_2","CPU1",10,111f);
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		int res=productMapper.updateById(product);
		System.out.println(res);
	}
	
	@Test
	public void testSaveReturnPK() {
		Product product=new Product(null,"C_1","CPU",100,12.4f);

	}
	
	@Test
	public void testSaveCar() {
		List<String> car_imgs=new ArrayList<>();
		car_imgs.add("12345.img");
		car_imgs.add("123456.img");
		car_imgs.add("1234567.img");
		Car car=new Car(null,"奥迪","甘A835v2",3590000f, car_imgs);
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
	    int res=productMapper.saveCar(car);
	    System.out.println(res);
		
	}
	@After
	public void testAfter() {
		sqlSession.commit();
		sqlSession.close();
	}
	

}
