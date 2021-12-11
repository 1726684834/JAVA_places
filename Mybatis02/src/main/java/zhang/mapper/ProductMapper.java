package zhang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zhang.pojo.Product;

import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/12/8 -21:43
 */
@Mapper
public interface ProductMapper {
    List<Product> selectAllProduct();
    Product selectProductByid(@Param ("id") int id);
    boolean insertProduct(Product product);
    boolean updateProduct(Product product);
    //批量插入，查看某条记录是否存在，不存在的话创建一条新记录，存在的话更新某些字段
    boolean insertMoreProduct(List<Product> productList);
    void insertMoreProduct02(@Param ("productList")List<Product> productList ,@Param ("tableName") String tableName);
    //批量插入返回批量生成的主键id值
    void insertMoreProduct03(List<Product> productList);
}
