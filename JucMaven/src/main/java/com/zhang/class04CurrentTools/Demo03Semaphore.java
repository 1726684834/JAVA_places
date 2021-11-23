package com.zhang.class04CurrentTools;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhangJunqi
 * @Date 2021/11/7 -21:38
 */
public class Demo03Semaphore {
    public static void main(String[] args) {
        //三个停车位六个人进
        Semaphore semaphore=new Semaphore (3);
        for (int i = 0; i < 6; i++) {
            new Thread (()->{
                try {
                    semaphore.acquire ();
                    System.out.println (Thread.currentThread ().getName ()+"进入");
                    TimeUnit.SECONDS.sleep (2);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }finally {
                    System.out.println (Thread.currentThread ().getName ()+"离开");
                    semaphore.release ();
                }
            },String.valueOf (i)).start ();
        }

    }
}
