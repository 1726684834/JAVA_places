package com.zhang.class09ForkJoin_CompletableFuture;

import java.util.concurrent.RecursiveTask;

/**
 * @author ZhangJunqi
 * @Date 2021/11/14 -14:30
 */
public class Demo01ForkJoin extends RecursiveTask<Long> implements Calculator {
    private long start;
    private long end;
    private final long  temp=1000L;

    public Demo01ForkJoin(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if((end-start)<temp){
            return sumUp (start,end);
        }else{
            long middle=(end + start)/2;
            Demo01ForkJoin left=new Demo01ForkJoin (start,middle);
            left.fork ();
            Demo01ForkJoin right=new Demo01ForkJoin (middle+1,end);
            right.fork ();
            return left.join ()+right.join ();
        }
    }


    @Override
    public long sumUp(long start, long end) {
        Long sum = 0L;
        for (Long i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}
