package com.zhang.class01pcLock;

/**
 * @author ZhangJunqi
 * @Date 2021/11/4 -23:49
 */
public class Demo01PC {
    public static void main(String[] args) {
        A a=new A ();
        new Thread (()->{
            for (int i = 0; i < 10; i++) {
                try {
                    a.add ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }).start ();

        new Thread (()->{
            for (int i = 0; i < 10; i++) {
                try {
                    a.del ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }).start ();
    }
}
class A{
    private int num=0;
    public synchronized void add() throws InterruptedException {
        while (num!=0){

                this.wait ();

        }
        num++;
        System.out.println ("add"+num);
        this.notifyAll ();
    }
    public synchronized void del() throws InterruptedException {
        while (num==0){

                this.wait ();

        }
        num--;
        System.out.println ("del"+num);
        this.notifyAll ();
    }
}