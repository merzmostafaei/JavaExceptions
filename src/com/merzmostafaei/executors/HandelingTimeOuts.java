package com.merzmostafaei.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class HandelingTimeOuts {

    public static void show(){
        var future = CompletableFuture.supplyAsync(()-> {
            LongTask.simulate();
            return 10;
        });

        try {
            //Throw The Exception whn timeOut
            //future.orTimeout(1, TimeUnit.SECONDS).get();
            var result = future
                    .completeOnTimeout(5,1,TimeUnit.SECONDS)
                    .get();
            System.out.println("TimeOut After 1 seond- Defult value is : "+result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
