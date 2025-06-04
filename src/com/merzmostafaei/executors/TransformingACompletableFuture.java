package com.merzmostafaei.executors;

import java.util.concurrent.CompletableFuture;

public class TransformingACompletableFuture {
    public static void show(){
        var future =CompletableFuture.supplyAsync(()-> 20);
        future
                .thenApply(TransformingACompletableFuture::toFahrenheit)
                .thenAccept(f-> System.out.println("TransformingResult "+f));

    }

    public static double toFahrenheit(int celsius){
        return (int)(celsius * 1.8) + 32;
    }
}
