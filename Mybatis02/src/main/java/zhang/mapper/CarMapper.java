package zhang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zhang.pojo.Car;

/**
 * @author ZhangJunqi
 * @Date 2021/12/12 -16:18
 */
@Mapper
public interface CarMapper {
    boolean saveCar(Car car);
}
