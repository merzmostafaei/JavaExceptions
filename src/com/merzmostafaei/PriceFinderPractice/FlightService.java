package com.merzmostafaei.PriceFinderPractice;

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
            try {
                Thread.sleep( 3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            var random = new Random();
            var price = 100+ random.nextFloat(10);
            return new Quote(site,price);
        });
    }
}
