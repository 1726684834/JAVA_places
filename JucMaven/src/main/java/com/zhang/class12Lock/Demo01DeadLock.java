package com.zhang.class12Lock;

/**
 * @author ZhangJunqi
 * @Date 2021/11/20 -20:29
 */
public class Demo01DeadLock {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";
        new Thread ( new MyThread (lockA,lockB)).start ();
        new Thread ( new MyThread (lockB,lockA)).start ();
    }
}
class MyThread implements Runnable{
    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread ().getName ()+" lockA "+lockA+"=get lockB"+lockB);
            synchronized (lockB){
                System.out.println(Thread.currentThread ().getName ()+" lockB "+lockB+"=get lockA"+lockA);
            }
        }
    }
}