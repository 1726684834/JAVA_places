package com.zhang.class09ForkJoin_CompletableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author ZhangJunqi
 * @Date 2021/11/14 -15:06
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       // test01 ();
       // test02 ();
        test03();
        /*
        500000000500000000  test01用时：9933
        500000000500000000  test02用时：8614   //临界值越小，分出的子任务越多
        500000000500000000  test03用时：443
         */
    }

    private static void test01() {
        Calculator calculator=(start,end)->{
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        };
        long startTime=System.currentTimeMillis ();
        Long sum=calculator.sumUp (0,10_0000_0000L);
        long endTime=System.currentTimeMillis ();
        System.out.println (sum+"  test01用时："+(endTime- startTime));
    }

    private static void test02() throws ExecutionException, InterruptedException {
        long startTime=System.currentTimeMillis ();
        ForkJoinPool forkJoinPool=new ForkJoinPool ();
        ForkJoinTask<Long> forkJoinTask=new Demo01ForkJoin (0,10_0000_0000L);
        ForkJoinTask<Long> submit=forkJoinPool.submit (forkJoinTask);
        long sum=submit.get ();
        long endTime=System.currentTimeMillis ();
        System.out.println (sum+"  test02用时："+(endTime- startTime));
    }
    private static void test03() {
        long startTime=System.currentTimeMillis ();
        //rangeClosed：(]   range：()
        long sum= LongStream.rangeClosed (0L,10_0000_0000L).parallel ().reduce (0,Long::sum);
        //.sum() 554    .reduce() 298
        long endTime=System.currentTimeMillis ();
        System.out.println (sum+"  test03用时："+(endTime- startTime));

    }
}
