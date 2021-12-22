package zhang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zhang.pojo.User;

import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/12/12 -21:28
 */
@Mapper
public interface UserMapper {
    User selectUserById(@Param ("id") int id);
}
