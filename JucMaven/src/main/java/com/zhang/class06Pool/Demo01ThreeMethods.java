package com.zhang.class06Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhangJunqi
 * @Date 2021/11/9 -22:11
 */
public class Demo01ThreeMethods {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService singPool=Executors.newSingleThreadExecutor ();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            singPool.execute (()->{
                System.out.println (Thread.currentThread ().getName ()+"-"+ finalI);
            });
        }
        singPool.shutdown ();
        TimeUnit.SECONDS.sleep (2);
        System.out.println ("---------------------");

        ExecutorService fixPool=Executors.newFixedThreadPool (3);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            fixPool.execute (()->{
                System.out.println (Thread.currentThread ().getName ()+"-"+ finalI);
            });
        }
        fixPool.shutdown ();
        TimeUnit.SECONDS.sleep (2);
        System.out.println ("---------------------");
        ExecutorService cachedPool=Executors.newCachedThreadPool ();//可伸缩
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            cachedPool.execute (()->{
                System.out.println (Thread.currentThread ().getName ()+"-"+ finalI);
            });
        }
        cachedPool.shutdown ();
    }
}
