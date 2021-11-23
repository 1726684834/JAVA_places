package com.zhang.class11CASAtomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author ZhangJunqi
 * @Date 2021/11/18 -22:04
 */
public class Demo01CAS {
    public static void main(String[] args) {
        //CAS compareAndSet : 比较并交换！
        //出现ABA操作：甲乙同时对一个共享变量A进行操作，在甲调用期间，已进行了A -B -A操作，虽然甲操作的是A，但是是变化过的
        AtomicInteger atomicInteger=new AtomicInteger (2022);
        System.out.println(atomicInteger);//2022

        atomicInteger.compareAndSet (2022,2023);//2023

        atomicInteger.incrementAndGet ();//2024

        atomicInteger.decrementAndGet();//2023

        atomicInteger.compareAndSet (2023,2022);//2022

        atomicInteger.compareAndSet (2022,6666);//6666
        System.out.println(atomicInteger);

        //Student student=new Student ("201701014","张俊琦",23);
        AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<Integer> (1,0);
        AtomicBoolean flag = new AtomicBoolean ();
        new Thread (()->{
            int temp=atomicStampedReference.getStamp ();
            System.out.println (Thread.currentThread ().getName ()+" 版本号"+temp);
            try {
                TimeUnit.SECONDS.sleep (1);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            //参数：当前值，期望值，版本号，期望版本号
            flag.set (atomicStampedReference.compareAndSet (1, 2, temp, temp + 1));
            System.out.println (flag);
            flag.set (atomicStampedReference.compareAndSet (2, 1, atomicStampedReference.getStamp (), atomicStampedReference.getStamp () + 1));
            System.out.println (flag);
        }).start ();

        new Thread (()->{
            int temp=atomicStampedReference.getStamp ();
            System.out.println (Thread.currentThread ().getName ()+" 版本号"+temp);
            try {
                TimeUnit.SECONDS.sleep (2);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            //参数：当前值，期望值，版本号，期望版本号
            flag.set (atomicStampedReference.compareAndSet (1,2,temp,temp+1));
            System.out.println (flag);
        }).start ();
    }
}
