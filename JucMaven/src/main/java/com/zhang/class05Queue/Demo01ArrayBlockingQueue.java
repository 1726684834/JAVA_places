package com.zhang.class05Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhangJunqi
 * @Date 2021/11/8 -21:54
 */
public interface Demo01ArrayBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        //test01 ();
        //test02 ();
        //test03 ();
        test04 ();
    }
    public static void test01(){
        //add  remove 普通抛出异常的  大于队列大小的入和出都会报异常
        ArrayBlockingQueue queue01=new ArrayBlockingQueue (3);

        //Queue full
        queue01.add ("a");
        queue01.add ("b");
        queue01.add ("c");
        queue01.add ("c");
        //NoSuchElementException
        queue01.remove ();
        queue01.remove ();
        queue01.remove ();
        queue01.remove ();
    }

    public static void test02(){
        //offer  poll 有返回值，不抛出异常  大于队列大小的入会返回false，和出返回null
        ArrayBlockingQueue queue02=new ArrayBlockingQueue (3);
        System.out.println (queue02.offer ("a"));
        System.out.println (queue02.offer ("a"));
        System.out.println (queue02.offer ("a"));
        System.out.println (queue02.offer ("a"));

        System.out.println ("----------");
        //System.out.println (queue02.offer ("a"));//会输出false
        System.out.println (queue02.poll ());
        System.out.println (queue02.poll ());
        System.out.println (queue02.poll ());
        System.out.println (queue02.poll ());//会输出null
    }

    public static void test03() throws InterruptedException {
        //put take 阻塞 等待  大于队列大小的入会阻塞  出会等待
        ArrayBlockingQueue queue03=new ArrayBlockingQueue (3);
        queue03.put ("a");
        queue03.put ("b");
        queue03.put ("c");
        //queue03.put ("a");

        System.out.println (queue03.take ());
        System.out.println (queue03.take ());
        System.out.println (queue03.take ());
        //System.out.println (queue03.take ());
    }

    public static void test04() throws InterruptedException {
        //offer(E e, long timeout, TimeUnit unit)  poll(long timeout, TimeUnit unit)
        //如果出慢入空，则进行等待
        ArrayBlockingQueue queue04=new ArrayBlockingQueue (3);
        System.out.println (queue04.offer ("a", 1, TimeUnit.SECONDS));
        System.out.println (queue04.offer ("b", 1, TimeUnit.SECONDS));
        System.out.println (queue04.offer ("c", 1, TimeUnit.SECONDS));
        System.out.println (queue04.offer ("d", 1, TimeUnit.SECONDS));//会等待一秒

        System.out.println ("---------");
        System.out.println (queue04.poll (1, TimeUnit.SECONDS));
        System.out.println (queue04.poll (1, TimeUnit.SECONDS));
        System.out.println (queue04.poll (1, TimeUnit.SECONDS));
        System.out.println (queue04.poll (1, TimeUnit.SECONDS));//会等待一秒
    }
}

