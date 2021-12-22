package springIOC;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhang.pojo.HelloSpring;
import zhang.pojo.People;
import zhang.pojoExtends.Monkey;

/**
 * @author ZhangJunqi
 * @Date 2021/12/16 -22:31
 */
public class SpringTest01 {
    Log log= LogFactory.getLog (this.getClass ());
    private ClassPathXmlApplicationContext cpac;
    @Before
    public void init(){
        cpac=new ClassPathXmlApplicationContext ("contextConfig.xml");
    }
    @Test
    public void helloSpringTest(){
        HelloSpring hello = (HelloSpring) cpac.getBean ("helloSpring");
        //hello.setMessage ("Hello Spring");
        //logger.info (hello.toString ());
        log.info (hello.toString ());
    }
    @Test
    public void getPeopleTest(){
       People people= (People) cpac.getBean ("people");
       log.info (people.toString ());
        People people02= (People) cpac.getBean ("people02");
        log.info (people02.toString ());
    }
    @Test
    public void importSourceXml(){
        Monkey monkey=(Monkey)cpac.getBean ("monkey");
        log.info (monkey.toString ());
    }
    @After
    public void close(){
        cpac.close ();
    }

}
