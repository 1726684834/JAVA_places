package zhang.text;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import zhang.mapper.CarMapper;
import zhang.mapper.ProductMapper;
import zhang.pojo.Car;
import zhang.pojo.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/12/8 -21:30
 */
public class CarMybatisTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private CarMapper carMapper=null;
    @Before
    public void testBefore() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream ("sqlMapConfig.xml");
        sqlSessionFactory= new SqlSessionFactoryBuilder().build (inputStream);
        sqlSession=sqlSessionFactory.openSession ();
        carMapper=sqlSession.getMapper (CarMapper.class);
   }
    @Test
    public void saveCar(){
        List<String> car_imgs=new ArrayList<>();
        car_imgs.add("12345.img");
        car_imgs.add("123456.img");
        car_imgs.add("1234567.img");
        Car car=new Car(null,"宝马","甘A835v2",3590000f, car_imgs);
        boolean b = carMapper.saveCar (car);
        System.out.println(b);
    }
    @After
    public void testAfter(){
        sqlSession.commit ();
        sqlSession.close ();
    }

}
