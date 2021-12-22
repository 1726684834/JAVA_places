package zhang.mapper.impl;

import org.springframework.stereotype.Repository;
import zhang.mapper.UserMapper;
import zhang.pojo.User;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:39
 */
@Repository
public class UserMapperImpl implements UserMapper {
    @Override
    public int saveUser(User user) {
        System.out.println("保存一个用户"+user.toString ());
        return 1;
    }
}
