package zhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhang.mapper.UserMapper;
import zhang.pojo.User;
import zhang.service.UserService;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:36
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser (user);
    }
}
