package zhang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zhang.pojo.Order;

/**
 * @author ZhangJunqi
 * @Date 2021/12/12 -21:09
 */
@Mapper
public interface OrderMapper {
    Order selectUserByOrderId(@Param ("id")int id);
    Order orderLazyToUser(@Param ("id")int id);
}
