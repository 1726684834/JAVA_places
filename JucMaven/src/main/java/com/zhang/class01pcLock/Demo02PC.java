package com.zhang.class01pcLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZhangJunqi
 * @Date 2021/11/4 -23:49
 */
public class Demo02PC {
    public static void main(String[] args) {
        B a=new B ();
        new Thread (()->{
            for (int i = 0; i < 11; i++) {
                try {
                    a.add ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }).start ();

        new Thread (()->{
            for (int i = 0; i < 11; i++) {
                try {
                    a.del ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }).start ();
    }
}

class B{
    private int num=0;
    Lock lock= new ReentrantLock();
    Condition condition=lock.newCondition ();//精准的通知和唤醒线程
    public  void add() throws InterruptedException {

        try {
            lock.lock ();
            while (num!=0){
                condition.await ();
            }
            num++;
            System.out.println ("add"+num);
            condition.signal ();
        } finally {
            lock.unlock ();
        }
    }
    public  void del() throws InterruptedException {

        try {
            lock.lock ();
            while (num==0){
                condition.await ();
            }
            num--;
            System.out.println ("del"+num);
            condition.signal ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } finally {
            lock.unlock ();
        }

    }
}