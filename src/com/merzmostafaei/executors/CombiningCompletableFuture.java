package com.merzmostafaei.executors;

import java.util.concurrent.CompletableFuture;

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
}
