package springIOC;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhang.pojoExtends.Address;
import zhang.pojoExtends.Monkey;
import zhang.pojoExtends.Primate;

/**
 * @author ZhangJunqi
 * @Date 2021/12/19 -20:23
 */
public class SpringBeanExtendsTest01 {
    private ClassPathXmlApplicationContext cpac;
    Log log= LogFactory.getLog (this.getClass ());
    @Before
    public void before(){
        cpac=new ClassPathXmlApplicationContext ("contextConfigBeanExtends.xml");
    }

    @Test
    public void beanExtendsTest01(){
        Primate primate=(Primate)cpac.getBean ("primate");
        log.info (primate.toString ());

        Monkey monkey=(Monkey)cpac.getBean ("monkey");
        log.info (monkey.toString ());

        Address address01=(Address)cpac.getBean ("address02");
        log.info (address01.toString ());
        Address address02=(Address)cpac.getBean ("address04");
        log.info (address02.toString ());
    }

    @After
    public void after(){
        cpac.close ();
    }
}
