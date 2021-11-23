package com.zhang.class12Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ZhangJunqi
 * @Date 2021/11/20 -20:09
 */
public class Demo01SpinLock {
    private AtomicReference atomicReference=new AtomicReference ();
    public  void lock() throws InterruptedException {
        Thread thread=Thread.currentThread ();
        System.out.println(thread.getName ()+"  Lock");
        while (!atomicReference.compareAndSet (null,thread)){
            TimeUnit.SECONDS.sleep (1);
            System.out.println(thread.getName ());
        }
    };

    public  void unLock(){
        Thread thread=Thread.currentThread ();
        System.out.println(thread.getName ()+"  nunLock");
        atomicReference.compareAndSet (thread,null);
    };

    public static void main(String[] args) throws InterruptedException {
        Demo01SpinLock spinLock=new Demo01SpinLock ();
        new Thread (()->{
            try {
                spinLock.lock ();
                TimeUnit.SECONDS.sleep (3);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }finally {
                spinLock.unLock ();
            }
        }).start ();

        TimeUnit.SECONDS.sleep (1);
        new Thread (()->{
            try {
                spinLock.lock ();
                TimeUnit.SECONDS.sleep (1);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }finally {
                spinLock.unLock ();
            }
        }).start ();
    }


}
