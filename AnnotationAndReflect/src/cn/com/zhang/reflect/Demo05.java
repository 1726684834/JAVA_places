package cn.com.zhang.reflect;

import javax.naming.Name;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ZhangJunqi
 * @Date 2021/11/28 -22:22
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        Class c1=Class.forName ("cn.com.zhang.reflect.Student");

        Student student01= (Student) c1.newInstance ();//调用无参构造方法
        System.out.println(student01);//Student{stuName='null', stuCode='null', stuAge=0}

        Constructor constructor=c1.getDeclaredConstructor (String.class,String.class,int.class);
        Student  student02= (Student) constructor.newInstance ("张俊琦","201701014",23);
        System.out.println (student02);//Student{stuName='张俊琦', stuCode='201701014', stuAge=23}

        //Student student03= (Student) c1.newInstance ();
        Method setStuName = c1.getMethod ("setStuName", String.class);
        //invoke:激活
        setStuName.invoke (student02,"罗钰超");
        System.out.println(student02);//Student{stuName='罗钰超', stuCode='201701014', stuAge=23}

        Field stuName = c1.getDeclaredField ("stuCode");
        stuName.setAccessible (true);//关闭安全性检测，否则操作private的变量会报错
        stuName.set (student02,"201701013");
        System.out.println(student02);//Student{stuName='罗钰超', stuCode='201701013', stuAge=23}
    }
}
