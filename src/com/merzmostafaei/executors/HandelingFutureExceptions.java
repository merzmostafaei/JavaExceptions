package com.merzmostafaei.executors;

import java.awt.*;
import java.awt.geom.IllegalPathStateException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HandelingFutureExceptions {
   public static void show(){
       var future = CompletableFuture.supplyAsync(()->{
           System.out.println("Getting the Current Weather");
           throw new IllegalPathStateException();});
       try {
           var temprature = future.exceptionally(ex-> 22).get();
           System.out.println(temprature);
       } catch (InterruptedException |ExecutionException e) {
           throw new RuntimeException(e);
       }

   }
}
