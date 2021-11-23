package com.zhang.class03Safe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhangJunqi
 * @Date 2021/11/6 -19:36
 */
public class Demo01List {
    public static void main(String[] args) throws InterruptedException {
        //
        List list02=new ArrayList ();
        for (int i = 0; i < 10000; i++) {
            new Thread (()->{
                list02.add (UUID.randomUUID ().toString ().substring (0,5));
            },String.valueOf (i)).start ();
        }
        TimeUnit.SECONDS.sleep (20);
        System.out.println (list02.size ());

        //Vector        syncornized慢
        //Collections.synchronizedList (new ArrayList ());

        //CopyOnWriteArrayList是写入时复制再给调用者，调用者全写完在放到list。
        // 都拿出来放在一个数组中结束后存入list可以看源码
        Set<String> set01 = new HashSet<> ();
        Set<String> set02 = new CopyOnWriteArraySet<> ();
        Map<String,String> map01=new HashMap<> ();
        Map<String,String> map02=new ConcurrentHashMap<> ();
        List list01=new CopyOnWriteArrayList ();

        for (int i = 0; i < 10001; i++) {
            new Thread (()->{
                list01.add (UUID.randomUUID ().toString ().substring (0,5));
            },String.valueOf (i)).start ();
        }
        TimeUnit.SECONDS.sleep (20);
        System.out.println (list01.size ());

        /*
        9999
        10000
        * */

    }
}
