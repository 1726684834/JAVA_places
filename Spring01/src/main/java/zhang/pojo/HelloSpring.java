package zhang.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;

/**
 * @author ZhangJunqi
 * @Date 2021/12/16 -22:32
 */
public class HelloSpring implements InitializingBean,DisposableBean {
    private String message;

    public HelloSpring(String message) {
        this.message = message;
    }

    public HelloSpring() {

    }

    public String getMessage() {
        return message;
    }

    public HelloSpring setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "HelloSpring{" +
                "message=" + message +
                '}';
    }
    public void init(){
        System.out.println("Spring init前值增强处理");
    }
    public void close(){System.out.println("Spring close后置增强处理");}

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现InitializingBeand的afterPropertiesSet()的前置增强方法方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("实现DisaposableBean的destory的后置增强方法");
    }
}
