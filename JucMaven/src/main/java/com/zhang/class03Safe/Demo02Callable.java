package com.zhang.class03Safe;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ZhangJunqi
 * @Date 2021/11/7 -15:55
 */
public class Demo02Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable callable=new MyCallable ();
        FutureTask futureTask=new FutureTask (callable);
        new Thread (futureTask,"A").start ();
        new Thread (futureTask,"A").start ();
        //只会输出一个Callable 因为结果会被缓存
        boolean b= (boolean) futureTask.get ();
        System.out.println (b);
        //结果可能被等待，会发生阻塞

    }
}
class MyCallable implements Callable<Boolean>{
    @Override
    public Boolean call() throws Exception {
        System.out.println("Callable");
        return true;
    }
}
