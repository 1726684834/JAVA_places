package zhang.text;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import zhang.mapper.OrderMapper;
import zhang.mapper.ProductMapper;
import zhang.pojo.Order;
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
public class OrderMybatisTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private OrderMapper orderMapper=null;
    @Before
    public void testBefore() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream ("sqlMapConfig.xml");
        sqlSessionFactory= new SqlSessionFactoryBuilder().build (inputStream);
        sqlSession=sqlSessionFactory.openSession ();
        orderMapper=sqlSession.getMapper (OrderMapper.class);
   }
    @Test
    public void selectUserByOrderId(){
        Order order = orderMapper.selectUserByOrderId (2);
        System.out.println (order.toString ());
    }

    @Test
    public void orderLazyToUser(){
        Order order = orderMapper.orderLazyToUser (1);
        System.out.println (order.toString ());
    }
    @After
    public void testAfter(){
        sqlSession.commit ();
        sqlSession.close ();
    }

}
