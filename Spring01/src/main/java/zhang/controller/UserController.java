package zhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import zhang.pojo.User;
import zhang.proxy.ServiceProxy;
import zhang.service.UserService;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:34
 */
@Controller
public class UserController {
    @Autowired
    ServiceProxy serviceProxy;

    @Autowired
    UserService userService;

    public int saveUser(User user){
        userService=(UserService)serviceProxy.build (userService);
        userService.saveUser (user);
        return 1;
    }
}
