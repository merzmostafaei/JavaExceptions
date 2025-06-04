package com.merzmostafaei.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFuturesDemo {
    public static void show(){
        Runnable task = () -> System.out.println("CompletableFuturesInAsync");
        // CompletableFuture use -> ForkJoinPool.commonPool() under the hood
        var future = CompletableFuture.runAsync(task);


        //for supplier to return something
        Supplier<Integer> taskint = () ->2;
        var futureint = CompletableFuture.supplyAsync(taskint);
        try {
            var resultsupply = futureint.get();
            System.out.println(resultsupply);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
