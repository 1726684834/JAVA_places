package com.zhang.class09ForkJoin_CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author ZhangJunqi
 * @Date 2021/11/14 -22:23
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture=CompletableFuture.supplyAsync (()->{
            System.out.println(Thread.currentThread ().getName ());
            int i=1/0;
            return 1024;
        });
        int i= completableFuture.whenComplete ((t, u)->{
            System.out.println("t="+t+" u="+u);
        }).exceptionally ((e)->{
            System.out.println(e);
            return 404;
        }).get ();
        System.out.println("i="+i);
    }
}
