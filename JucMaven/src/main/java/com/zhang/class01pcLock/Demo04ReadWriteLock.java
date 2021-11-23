package com.zhang.class01pcLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ZhangJunqi
 * @Date 2021/11/7 -22:03
 */
public class Demo04ReadWriteLock {
    public static void main(String[] args) {
        MyReadeWriteLock myReadeWriteLock=new MyReadeWriteLock ();
        for (int i = 0; i < 5; i++) {
            final String str = String.valueOf (i);
            new Thread (()->{
                myReadeWriteLock.write (str,str);
            },String.valueOf (i)).start ();
        }

        for (int i = 0; i < 5; i++) {
            final String str = String.valueOf (i);
            new Thread (()->{
                myReadeWriteLock.read (str);
            },String.valueOf (i)).start ();
        }
    }
}
class MyReadeWriteLock{
    private  volatile Map<String,String> map = new HashMap<String, String> ();
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock ();
    public void write(String key,String value){
        try {
            readWriteLock.writeLock ().lock ();
            System.out.println (Thread.currentThread ().getName ()+"开始写入");
            map.put (key,value);
            System.out.println (Thread.currentThread ().getName ()+"写入成功");
        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            readWriteLock.writeLock ().unlock ();
        }
    }

    public void read(String key){
        try {
            readWriteLock.readLock ().lock ();
            System.out.println (Thread.currentThread ().getName ()+"开始读");
            map.get (key);
            System.out.println (Thread.currentThread ().getName ()+"读出成功");
        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            readWriteLock.readLock ().unlock ();
        }
    }
}