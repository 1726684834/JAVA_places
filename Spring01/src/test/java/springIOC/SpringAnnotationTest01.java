package springIOC;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhang.annotationPojo.DateSource;
import zhang.annotationPojo.People;

/**
 * @author ZhangJunqi
 * @Date 2021/12/16 -22:31
 */
public class SpringAnnotationTest01 {
    Log log= LogFactory.getLog (this.getClass ());
    private ClassPathXmlApplicationContext cpac;
    @Before
    public void init(){
        cpac=new ClassPathXmlApplicationContext ("contextConfigAnnotation.xml");
    }
    @Test
    public void peopleTest(){
        People people=(People)cpac.getBean ("people");
        log.info (people.toString ());
    }
    @Test
    public void dateSourceTest(){
        DateSource dateSource=(DateSource)cpac.getBean ("dateSource");
        log.info (dateSource.toString ());
    }
    @After
    public void close(){
        cpac.close ();
    }

}
