package cn.com.zhang.reflect;

import java.lang.annotation.ElementType;

/**
 * @author ZhangJunqi
 * @Date 2021/11/28 -19:43
 */
public class Demo02 {
    public static void main(String[] args) {
        Class c1=Object.class;     //类   class java.lang.Object
        Class c2=Comparable.class; //接口 interface java.lang.Comparable
        Class c3=String[].class;   //数组 class [Ljava.lang.String;
        Class c4=int[][].class;    //二维数组  class [[I
        Class c5=Override.class;  //注解   interface java.lang.Override
        Class c6= ElementType.class; //枚举 class java.lang.annotation.ElementType
        Class c7=Boolean.class;   //基本数据类型 class java.lang.Boolean
        Class c8=void.class;      //void    void
        Class c9=Class.class;     //      class java.lang.Class
        int[] a=new int[10];
        int[] b=new int[100];
        System.out.println(a.hashCode ()==b.hashCode ());//false
        System.out.println(a.getClass ().hashCode ()==b.getClass ().hashCode ());//true
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
    }
}
