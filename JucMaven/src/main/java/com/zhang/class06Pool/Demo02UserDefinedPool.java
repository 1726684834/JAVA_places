package com.zhang.class06Pool;

import java.util.concurrent.*;

/**
 * @author ZhangJunqi
 * @Date 2021/11/9 -23:10
 */
public class Demo02UserDefinedPool {
    public static void main(String[] args) {
        //七大参数
        ExecutorService  userDefinedPool=new ThreadPoolExecutor (
                2,//核心线程池大小
                5,//最大线程数：当核心线程和阻塞队列满了会触发
                2,//超时等待时间
                TimeUnit.SECONDS,
                new LinkedBlockingQueue <>(3),//阻塞队列
                Executors.defaultThreadFactory (),//默认线程工厂
                new ThreadPoolExecutor.AbortPolicy ());//终止策略
        /*
        终止策略:
            (1)AbortPolicy 中止策略：
                满了抛出异常RejectedExecutionException   线程数量 > 最大线程大小+阻塞队列大小
            (2)CallerRunsPolicy 调用者执行策略 ：
                当线程池无法继续接收提交的任务时，其会交由调用者(提交任务的线程（一般是main线程）)去执行完成
            (3)DiscardOldestPolicy 丢弃最老策略：
                当提交的任务无空闲线程执行或任务队列已满时，则会丢弃队列中最旧的任务以释放空间来存储该任务
            (4)DiscardPolicy 丢弃策略：
                无空闲线程执行或任务队列已满时，会直接被丢弃且不会产生任何异常
        */

        for (int i = 1; i <=9; i++) {
            int finalI = i;
            userDefinedPool.execute (()->{
                System.out.println (Thread.currentThread ().getName ()+" -"+ finalI);
            });
        }
        userDefinedPool.shutdown ();

        ExecutorService executorService=new ThreadPoolExecutor (2,
                5,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<> (5),
                Executors.defaultThreadFactory (),
                new ThreadPoolExecutor.DiscardPolicy ());

    }
}
