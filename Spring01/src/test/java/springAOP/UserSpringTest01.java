package springAOP;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhang.controller.UserController;
import zhang.pojo.User;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:45
 */
public class UserSpringTest01 {
    private ClassPathXmlApplicationContext cpac;
    Log log= LogFactory.getLog (this.getClass ());
    @Before
    public void before(){
        cpac=new ClassPathXmlApplicationContext ("contextConfigAnnotation.xml");
    }
    @Test
    public void saveUserTest(){
        User user= (User) cpac.getBean ("user");
        user.setId (1);
        user.setUserCode ("201701014");
        user.setUserName ("张三");
        user.setUserPsw ("123456");
        log.info (user.toString ());

        UserController userController=(UserController)cpac.getBean ("userController");
        int res = userController.saveUser (user);
        log.info (res);
    }
    @After
    public void close(){
        cpac.close ();
    }
}
