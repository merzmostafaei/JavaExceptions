package com.merzmostafaei.PriceFinderPractice;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFuturesDemo {
    public static void show(){
        var start = LocalTime.now();
        var service = new FlightService();
        var futures = service
                .getQuotes()
                .map(future-> future.thenAccept(System.out::println))
                .collect(Collectors.toList());
        //-- This code for see to terminate the we send empety array to result be ComputebleFutureArray to be complite
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRun(()->{
        var end = LocalTime.now();
        var duration = Duration.between(start,end);
            System.out.println("Retrieved all Quote in " + duration.toMillis() +" msec.");
        });
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
