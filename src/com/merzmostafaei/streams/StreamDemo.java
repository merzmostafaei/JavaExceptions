package com.merzmostafaei.streams;

import java.util.List;

public class StreamDemo {
    public static void show(){
        System.out.println("Stream");
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );

    //Imprative Programming
        System.out.println("Imprative Programming");
        int count = 0;
        for(var movie : movies)
            if (movie.getLike()>10)
                count++;
        System.out.println(count);

    //Declerative Programming
        System.out.println("Declerative Programming");

        var count2 = movies
                .stream()
                .filter(movie -> movie.getLike()>10)
                .count();
        System.out.println(count2);
    }


}
