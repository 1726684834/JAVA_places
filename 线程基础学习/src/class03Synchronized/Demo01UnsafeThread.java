package class03Synchronized;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/10/31 -11:24
 */
public class Demo01UnsafeThread {
    public static void main(String[] args) throws InterruptedException {
         /*
        线程不安全例子
        1.同时抢票   10个人抢5张票会出现有人抢到第0张或-1张票
        2.同时存取钱 会出现余额为0的时候取出来钱   或者同时取钱
        3.线程不安全集合
        CopyOnWriteArrayList 是一个线程安全的集合

        */
        List<String> lists=new ArrayList<String> ();
        for (int i = 0; i < 100000; i++) {
            new Thread (()->{
                synchronized (lists){
                    lists.add (Thread.currentThread ().getName ());
                }
            }).start ();
        }
        Thread.sleep (10000);
        System.out.println ("lists.size = " + lists.size ());
        //会出现 100000-99955 少了45  加了synchronized(){} 代码块就会同步lists
    }


}
class BuyTicket implements Runnable {
    private int tickets=5;
    private boolean flag=true;
    @Override
    public void run() {
            buy ();

    }

    public synchronized void buy(){
        if(tickets<=0){
            System.out.println ("没票了");
            flag=false;
            return;
        }
        System.out.println (Thread.currentThread ().getName ()+"买第"+(tickets--)+"张票");
    }

    public static void main(String[] args) {
        //十个人抢五张票
        BuyTicket buyTicket= new BuyTicket ();
        new Thread (buyTicket,"a").start ();
        new Thread (buyTicket,"b").start ();
        new Thread (buyTicket,"c").start ();
        new Thread (buyTicket,"d").start ();
        new Thread (buyTicket,"e").start ();
        new Thread (buyTicket,"f").start ();
        new Thread (buyTicket,"g").start ();
        new Thread (buyTicket,"h").start ();
        new Thread (buyTicket,"i").start ();
        new Thread (buyTicket,"j").start ();
    }

}


