package com.zhang.class10Single;

import java.lang.reflect.Constructor;

/**
 * @author ZhangJunqi
 * @Date 2021/11/17 -22:40
 */
public enum Demo03EnumSingleton {
    INSTANCE;
    private static Demo03EnumSingleton getInstance(){
        return  INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        Demo03EnumSingleton instance=Demo03EnumSingleton.INSTANCE;
        Constructor<Demo03EnumSingleton> constructor=Demo03EnumSingleton.class.getDeclaredConstructor (String.class,int.class);
        constructor.setAccessible (true);
        Demo03EnumSingleton instance02=constructor.newInstance ();
        System.out.println(instance);
        System.out.println(instance02);//Cannot reflectively create enum objects
    }
}
