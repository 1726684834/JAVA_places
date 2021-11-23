package com.zhang.class07FourInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author ZhangJunqi
 * @Date 2021/11/10 -23:34
 */
public class Demo01FourInterface {
    public static void main(String[] args) {
        // 1. 函数形接口  Function   R apply(T t) 表示接受一个参数并产生结果的函数。
        Function function=(a)->{
            return  a;
        };
        System.out.println (function.apply ("love"));
        System.out.println ("-------");

        // 2. 断定型接口 Predicate  boolean test(T t)
        Predicate<String> predicate=(a)->{
            return a.isEmpty ();
        };
        System.out.println (predicate.test ("love"));
        System.out.println ("-------");
        //3. Consumer消费型接口  accept(T t)只有输入没有返回值

        Consumer consumer=(str)->{
            System.out.println (str);
        };
        consumer.accept ("love");
        System.out.println ("-------");
        //4.供给型接口 Supplier  T get()只有返回值没有输入
        Supplier supplier=()->{return 1024;};
        System.out.println (supplier.get ());
    }
}
