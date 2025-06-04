package com.merzmostafaei.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombiningCompletableFuture {

    //1- get the price of product of dollar
    //2- exchange it to euro
    public static void show(){
        var first = CompletableFuture
                .supplyAsync(()->"20USD")
                .thenApply(str->{
            var price =  str.replace("USD","");
            return Integer.parseInt(price);
        });

        var second = CompletableFuture.supplyAsync(()->0.9);

        first
                .thenCombine(second,(price,exchange)-> price * exchange)
                .thenAccept(result-> System.out.println("CombiningCompletableFuture"+result));
    }

    //--Wait for many task
    public static void manyTask(){
        var first = CompletableFuture.supplyAsync(()->10);
        var second = CompletableFuture.supplyAsync(()->11);
        var third = CompletableFuture.supplyAsync(()->12);
        var forth = CompletableFuture.supplyAsync(()->13);

        var all = CompletableFuture.allOf(first,second,third,forth);
        all.thenRun(()-> {
           // we can call every Async cmplatable future seperate as well
            try {
                var resultFirst = first.get();
                System.out.println("Result Of First Task : "+resultFirst);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            System.out.println("All Tasks Complete Successfully");

        });

    }
    //Waiting For the First Task
    //Use For Slow Service
    public static void Taskdelay(){
        var first = CompletableFuture.supplyAsync(()->{LongTask.simulate();
        return 20; });

        var second = CompletableFuture.supplyAsync(()->20);

        CompletableFuture
                .anyOf(first,second)
                .thenAccept(temp-> System.out.println("Get The Result Of 2 Service if One of them has Delay : "+temp));



    }
}
