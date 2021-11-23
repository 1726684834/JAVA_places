package com.zhang.class03Safe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhangJunqi
 * @Date 2021/11/14 -14:51
 */
public class AtomicIntegerTest {

    private static final int THREADS_CONUT = 20;
    public static AtomicInteger count = new AtomicInteger (0);
//  public static volatile int count = 0;
    public static void increase() {
//        count++;
        count.incrementAndGet ();
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }
//        while (Thread.activeCount() > 1) {
//            Thread.yield();//用这个输出不出来结果
//        }

        TimeUnit.SECONDS.sleep (10);
        System.out.println(count);//20000
        /*
        volatile修饰：  18841    volatile保证可见性不保证原子性
        AtomicInteger： 20000 正常
         */
    }
}