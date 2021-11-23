package com.zhang.class01pcLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZhangJunqi
 * @Date 2021/11/6 -14:24
 */
//精准通知唤醒线程
public class Demo03PC {
    public static void main(String[] args) {
        C c=new C ();
        new Thread (()->{
            for (int i = 0; i < 10; i++) {
                c.printA ();
            }
        },"A").start ();

        new Thread (()->{
            for (int i = 0; i < 10; i++) {
                c.printB ();
            }
        },"B").start ();

        new Thread (()->{
            for (int i = 0; i < 10; i++) {
                c.printC ();
            }
        },"C").start ();
    }
}
class C{
    private Lock lock= new ReentrantLock();
    private Condition condition01=lock.newCondition ();
    private Condition condition02=lock.newCondition ();
    private Condition condition03=lock.newCondition ();
    private int num=1;
    public void printA(){
        try {
            lock.lock ();
            while (num!=1){
                condition01.await ();
            }
            System.out.println (Thread.currentThread ().getName ()+">AAA");
            TimeUnit.MILLISECONDS.sleep (500);
            num=2;
            condition02.signal ();
            lock.lock ();
        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            lock.unlock ();
        }
    }

    public void printB(){
        try {
            lock.lock ();
            while (num!=2){
                condition02.await ();
            }
            System.out.println (Thread.currentThread ().getName ()+">BBB");
            TimeUnit.MILLISECONDS.sleep (500);
            num=3;
            condition03.signal ();
            lock.lock ();
        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            lock.unlock ();
        }
    }

    public void printC(){
        try {
            lock.lock ();
            while (num!=3){
                condition03.await ();
            }
            System.out.println (Thread.currentThread ().getName ()+">CCC");
            TimeUnit.MILLISECONDS.sleep (500);
            num=1;
            condition01.signal ();
            lock.lock ();
        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            lock.unlock ();
        }
    }
}
