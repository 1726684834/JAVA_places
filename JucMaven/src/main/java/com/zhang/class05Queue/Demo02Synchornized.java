package com.zhang.class05Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhangJunqi
 * @Date 2021/11/8 -23:02
 */
public class Demo02Synchornized {
    public static void main(String[] args) {
        BlockingQueue<String> synchronousQueue=new SynchronousQueue<> ();
        new Thread (()->{
            try {
                System.out.println (Thread.currentThread ().getName ()+"put1");
                synchronousQueue.put ("a");
                System.out.println (Thread.currentThread ().getName ()+"put2");
                synchronousQueue.put ("b");
                System.out.println (Thread.currentThread ().getName ()+"put3");
                synchronousQueue.put ("c");
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }

        },"T1").start ();

        new Thread (()->{
            try {
                TimeUnit.SECONDS.sleep (2);
                System.out.println (Thread.currentThread ().getName ()+"take="+synchronousQueue.take ());
                TimeUnit.SECONDS.sleep (2);
                System.out.println (Thread.currentThread ().getName ()+"take="+synchronousQueue.take ());
                TimeUnit.SECONDS.sleep (2);
                System.out.println (Thread.currentThread ().getName ()+"take="+synchronousQueue.take ());
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }).start ();
    }
}
