package cn.com.zhang.reflect;

import java.util.Map;

/**
 * @author ZhangJunqi
 * @Date 2021/11/28 -20:19
 */
public class Demo03ClassLoader {
    static {
        System.out.println("Main类静态代码块被初始化");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //主动引用
//        A a=new A ();
//        System.out.println(a.m);

        /*
        Main类静态代码块被初始化
        A静态代码块初始化1
        父类静态代码块初始化
        A无参构造方法
        1
         */

        //Class.forName ("cn.com.zhang.reflect.A");
        /*
        Main类静态代码块被初始化
        父类静态代码块初始化
        A静态代码块初始化1
         */

        //被动引用
        //System.out.println (A.n);
        /*
        Main类静态代码块被初始化
        父类静态代码块初始化
        1
         */

        A[] a=new A[1];
        //Main类静态代码块被初始化
    }
}
class AFather{
    static int n=1;
    static {
        System.out.println("父类静态代码块初始化");
    }
}
class A extends AFather{
    static {
        System.out.println("A静态代码块初始化1");
        m=2;
    }
    static int m=1;
    public A() {
        System.out.println("A无参构造方法");
    }
}
