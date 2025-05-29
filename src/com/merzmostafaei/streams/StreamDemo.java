package com.merzmostafaei.streams;

import java.util.Comparator;
import java.util.List;

public class StreamDemo {
    public static void show(){
        System.out.println("Stream");
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 30),
                new Movie("c", 20)
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


        //--SlicingStream
        System.out.println("SlicingStream");
        System.out.println("SlicingStreamSkip");
        movies
                .stream()
                .skip(2)
                .forEach(movie -> System.out.println(movie.getTitle()));

        System.out.println("SlicingStreamTakeWhile");
        movies
                .stream()
                .takeWhile(movie -> movie.getLike()<30)
                .forEach(movie -> System.out.println(movie.getTitle()));

        System.out.println("SlicingStreamDropWhile");
        movies
                .stream()
                .dropWhile(movie -> movie.getLike()<30)
                .forEach(movie -> System.out.println(movie.getTitle()));

        //--Sorte method
        System.out.println("sorted method");

        movies.stream()
                //.sorted((a,b)-> a.getTitle().compareTo(b.getTitle()))
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .forEach(m-> System.out.println(m.getTitle()));


    }




}
