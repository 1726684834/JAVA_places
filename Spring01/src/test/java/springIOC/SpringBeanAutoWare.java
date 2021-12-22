package springIOC;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhang.pojo.People;
import zhang.pojoExtends.Address;
import zhang.pojoExtends.Monkey;
import zhang.pojoExtends.Primate;

/**
 * @author ZhangJunqi
 * @Date 2021/12/19 -20:23
 */
public class SpringBeanAutoWare {
    private ClassPathXmlApplicationContext cpac;
    Log log= LogFactory.getLog (this.getClass ());
    @Before
    public void before(){
        cpac=new ClassPathXmlApplicationContext ("contextConfigAutoWare.xml");
    }

    @Test
    public void beanExtendsTest01(){
        People people=(People)cpac.getBean ("people");
        log.info (people.toString ());
    }

    @After
    public void after(){
        cpac.close ();
    }
}
