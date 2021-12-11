package zhang.text;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import zhang.mapper.ProductMapper;
import zhang.pojo.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/12/8 -21:30
 */
public class ProductMybatisTest01 {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private ProductMapper productMapper=null;
    @Before
    public void testBefore() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream ("sqlMapConfig.xml");
        sqlSessionFactory= new SqlSessionFactoryBuilder().build (inputStream);
        sqlSession=sqlSessionFactory.openSession ();
        productMapper=sqlSession.getMapper (ProductMapper.class);
   }
    @Test
    public void selectAllProductTest(){
        List<Product> productList = productMapper.selectAllProduct ();
        for (Product product : productList){
            System.out.println (product.toString ());
        }
    }
    @Test
    public void selectProductById(){
        Product product=productMapper.selectProductByid (3);
        System.out.println ("Product="+product.toString ());
    }
    @Test
    public void insertProduct(){
        Product product=new Product (6,"c_5","cpu2.0",100,999.99);
        boolean b=productMapper.insertProduct (product);
        System.out.println ("boolean="+b);
    }
    @Test
    public void updateProduct(){
        Product product=new Product (6,"c_5","cpu3.0",101,999.99);
        boolean b=productMapper.updateProduct (product);
        System.out.println ("boolean="+b);
    }
    @Test
    public void insertMoreProduct(){
        //批量插入，proCode和proNam是唯一索引，如果这两个重复，则只更新不插入
        Product product01=new Product ("c_6","cpu3.0",105,9999.99);
        Product product02=new Product ("c_6","cpu3.0",103,999.99);
        Product product03=new Product ("c_8","cpu3.0",104,999.99);
        Product product04=new Product ("c_5","cpu3.0",105,9999.99);
        List<Product> productList=new ArrayList<Product> (){{
            add (product01);
            add (product02);
            add (product03);
            add (product04);
        }};
            boolean b=productMapper.insertMoreProduct (productList);
            System.out.println("insertMoreProduct:"+b);

    }
    @Test
    public void insertMoreProduct02(){
        //通过@Param注解声明插入
        Product product01=new Product ("c_7","cpu3.0",105,9999.99);
        Product product02=new Product ("c_9","cpu3.0",103,999.99);
        List<Product> productList=new ArrayList<Product> (){{
            add (product01);
            add (product02);
        }};
        String tableName="product";
        productMapper.insertMoreProduct02 (productList,tableName);
    }

    @Test
    public void insertMoreProduct03(){
        //批量插入返回批量生成的主键id值,
        Product product01=new Product ("c_10","cpu3.0",105,9999.99);
        Product product02=new Product ("c_11","cpu3.0",103,999.99);
        List<Product> productList=new ArrayList<Product> (){{
            add (product01);
            add (product02);
        }};
        productMapper.insertMoreProduct03 (productList);
        System.out.println(productList);
    }

    //返回

    @After
    public void testAfter(){
        sqlSession.commit ();
        sqlSession.close ();
    }

}
