package com.merzmostafaei.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show(){
        var executor = Executors.newFixedThreadPool(2);
        try {
            //Runable function
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName());

            });
        } finally {
            executor.shutdown();
        }

        //--Callable Function
            var future = executor.submit(() -> {
                LongTask.simulate();
                return 1;
            });
            System.out.println("Do more work");
            try {

                var result = future.get();
                System.out.println(result);

            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            } catch (RuntimeException e) {
            throw new RuntimeException(e);

        }
    }
    public static void Comletion(){
        //None Async
        var future = CompletableFuture.supplyAsync(()->3);
        future.thenAccept(result ->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });
        //Async
        var futureAsync = CompletableFuture.supplyAsync(()->4);
        futureAsync.thenAcceptAsync(result ->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
