package ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ssm.pojo.Car;
import ssm.pojo.Product;
@Mapper
public interface ProductMapper {
	Integer saveOne(Product product);
	Integer deleteById(@Param ("id") Integer id);
	Integer updateById(Product product);
	List<Product> selectAll();
	List<Product> selectById(Integer id);
	List<Product> selectLikeName(String name);
	Integer saveCar(Car car);
}
