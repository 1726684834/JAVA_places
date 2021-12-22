package zhang.mapper;

import org.apache.ibatis.annotations.Mapper;
import zhang.pojo.User;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:38
 */
@Mapper
public interface UserMapper {
    int saveUser(User user);
}
