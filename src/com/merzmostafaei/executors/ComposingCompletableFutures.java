package com.merzmostafaei.executors;

import java.util.concurrent.CompletableFuture;

public class ComposingCompletableFutures {
    public static CompletableFuture<String> getUserEmaliAsync(){
        return CompletableFuture.supplyAsync(()->"email");
    }
    public static CompletableFuture<String> getPlayAsync(String email){
        return CompletableFuture.supplyAsync(()->"playlist");
    }
    public static void show(){
        getUserEmaliAsync().thenCompose(ComposingCompletableFutures::getPlayAsync).thenAccept(playlist -> System.out.println("Composing email->playlist :"+playlist));
    }

}
