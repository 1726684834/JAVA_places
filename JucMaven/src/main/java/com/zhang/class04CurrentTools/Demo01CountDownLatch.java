package com.zhang.class04CurrentTools;

import java.util.concurrent.CountDownLatch;

/**
 * @author ZhangJunqi
 * @Date 2021/11/7 -16:58
 */
public class Demo01CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch downLatch=new CountDownLatch (5);
        for (int i = 0; i < 5; i++) {
            new Thread (()->{
                long l=downLatch.getCount ();
                System.out.println (l);
                downLatch.countDown ();
            },String.valueOf (i)).start ();
        }
        downLatch.await ();
        System.out.println ("计数器结束 count="+downLatch.getCount ());
    }
}
