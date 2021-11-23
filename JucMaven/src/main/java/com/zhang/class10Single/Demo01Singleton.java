package com.zhang.class10Single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author ZhangJunqi
 * @Date 2021/11/17 -21:54
 */
public class Demo01Singleton {
    private static boolean flag=false;
    private Demo01Singleton(){
//        synchronized (Demo01Singleton.class){
//            if(instance !=null){
//                throw new RuntimeException ("禁止反射！");
//            }
//
//        }
        synchronized (Demo01Singleton.class){
            if(!flag){
                flag=true;
            }else{
                throw new RuntimeException ("禁止反射！");
            }

        }
    }
    //DCL懒汉式 volatile防止指令重排 Synchronized保证同步
    private static volatile Demo01Singleton instance;
    private static Demo01Singleton getInstance(){
        if(instance==null){
            synchronized (Demo01Singleton.class){
                if(instance==null){
                    instance=new Demo01Singleton ();//不是原子性操作
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception{
//        for (int i = 0; i < 10; i++) {
//            new Thread (()->{
//                instance.getInstance();
//            }).start();
//        }
        //  1
        //Demo01Singleton instance01=instance.getInstance();
        //System.out.println(instance01);//com.zhang.class10Single.Demo01Singleton@1540e19d
        //反射破解单例
        Field flag=Demo01Singleton.class.getDeclaredField ("flag");
        flag.setAccessible (true);
        Constructor<Demo01Singleton> constructor= Demo01Singleton.class.getDeclaredConstructor (null);
        constructor.setAccessible (true);
        Demo01Singleton instance02=constructor.newInstance ();

        flag.set (instance02,false);
        Demo01Singleton instance03=constructor.newInstance ();
        System.out.println(instance02);//com.zhang.class10Single.Demo01Singleton@1540e19d
        System.out.println(instance03);//com.zhang.class10Single.Demo01Singleton@677327b6


    }
}
