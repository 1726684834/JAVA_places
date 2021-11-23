package com.zhang.class04CurrentTools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ZhangJunqi
 * @Date 2021/11/7 -17:15
 */
public class Demo02CyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier (5,new CyclicBarrierRunnable ());
        for (int i = 0; i < 5; i++) {
            final int a=i;
            new Thread (()->{
                try {
                    System.out.println (a);
                    cyclicBarrier.await ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace ();
                }
            }).start ();
        }
    }
}
class CyclicBarrierRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println ("启动CyclicBarrierRunnable");
    }
}
