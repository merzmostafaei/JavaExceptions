package com.merzmostafaei.streams;

import java.util.Comparator;
import java.util.List;

public class StreamDemo {
    public static void show(){
        System.out.println("Stream");
        List<Movie> movies = List.of(
                new Movie("a", 10),
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

        //--Getting unique Element
        System.out.println("Getting unique Element");

        movies.stream()
                .map(Movie::getLike)
                .distinct()
                .forEach(System.out::println);

        //SimpleReducer
        System.out.println("simpleReducer");


        var anymatch= movies.stream().anyMatch(movie -> movie.getLike()>20);

        System.out.println(anymatch);

        var allmatch = movies.stream().allMatch(movie -> movie.getLike()>20);

        System.out.println(allmatch);

        var nonematch = movies.stream().noneMatch(movie -> movie.getLike()>20);

        System.out.println(nonematch);

        var findfirst = movies.stream().findFirst().get();

        System.out.println(findfirst);

        var findany = movies.stream().findAny().get();

        System.out.println(findany);

        var max = movies.stream().max(Comparator.comparing(Movie::getLike)).get();

        System.out.println(max);

        var min = movies.stream().min(Comparator.comparing(Movie::getLike)).get();

        System.out.println(min);






    }




}
