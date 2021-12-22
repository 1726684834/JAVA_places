package zhang.text;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import zhang.mapper.ProductMapper;
import zhang.mapper.UserMapper;
import zhang.pojo.Order;
import zhang.pojo.Product;
import zhang.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/12/8 -21:30
 */
public class UserMybatisTest {
    //private Log log = LogFactory.getLog(this.getClass());
    Logger logger=Logger.getLogger (this.getClass ());
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserMapper userMapper=null;
    @Before
    public void testBefore() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream ("sqlMapConfig.xml");
        sqlSessionFactory= new SqlSessionFactoryBuilder().build (inputStream);
        sqlSession=sqlSessionFactory.openSession ();
        userMapper=sqlSession.getMapper (UserMapper.class);
   }
    @Test
    public void selectAllProductTest(){
        User user = userMapper.selectUserById (2);
        logger.info (user);
        //System.out.println (user);
    }
    @After
    public void testAfter(){
        sqlSession.commit ();
        sqlSession.close ();
    }

}
