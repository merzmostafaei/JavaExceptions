package com.merzmostafaei.PriceFinderPractice;

import com.merzmostafaei.executors.LongTask;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightService {
    public Stream<CompletableFuture<Quote>> getQuotes(){
        var sites = List.of("site1","site2","site3");
        return sites.stream().map(this::getQuote);

    }

    public CompletableFuture<Quote> getQuote(String site){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("Getting a quote from : "+ site);
            //-- we use random object to pass random number to delay
            var random = new Random();
            LongTask.simulate(1_000+ random.nextInt(2_000));
            var price = 100+ random.nextFloat(10);
            return new Quote(site,price);
        });
    }
}
