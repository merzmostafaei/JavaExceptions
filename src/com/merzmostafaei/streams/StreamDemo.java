package com.merzmostafaei.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void show(){
        System.out.println("Stream");
        List<Movie> movies = List.of(
                new Movie("a", 10,Genre.THRILLER),
                new Movie("a", 10,Genre.ACTION),
                new Movie("b", 30,Genre.COMEDY),
                new Movie("c", 20,Genre.ACTION)
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


        //--Reducing Stream
        System.out.println("Reducing Stream");

        Optional<Integer> sum = movies.stream()
                .map(m -> m.getLike()).reduce(Integer::sum);
                //.reduce((a,b)-> a+b);


        System.out.println(sum.orElse(0));

        //--Collectors - collect Stream -> Collection like as List
        System.out.println("Collectors");

        System.out.println("collectorlist ");

        var collectorlist = movies.stream()
                .filter(movie -> movie.getLike()>10)
                .collect(Collectors.toList());
        System.out.println(collectorlist);

        System.out.println("collectorSet");

        var collectorset = movies.stream()
                .filter(movie -> movie.getLike()>10)
                .collect(Collectors.toSet());
        System.out.println(collectorset);

        System.out.println("collectorHashSaveTitleAndmemoryIdentity");

        var collectorHash = movies.stream()
                .filter(movie -> movie.getLike()>10)
                .collect(Collectors.toMap(Movie::getTitle, Function.identity()));
        System.out.println(collectorHash);

        System.out.println("collectorSumInt");

        var collectorSumInt = movies.stream()
                .filter(movie -> movie.getLike()>10)
                .collect(Collectors.summingInt(Movie::getLike));
        System.out.println(collectorSumInt);

        System.out.println("collectorSummarizing");

        var collectorSummarizing = movies.stream()
                .filter(movie -> movie.getLike()>10)
                .collect(Collectors.summarizingDouble(Movie::getLike));
        System.out.println(collectorSummarizing);

        System.out.println("collectorDelimiter");

        var collectorDelimiter = movies.stream()
                .filter(movie -> movie.getLike()>10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(","));

        System.out.println(collectorDelimiter);

        //--Grouping Element - we want Classifier movies bace on genre
        System.out.println("Grouping Element");

        System.out.println("groupingToSet");
        var groupingToSet = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,Collectors.toSet()));
        System.out.println(groupingToSet);

        System.out.println("groupingToCounting");
        var groupingToCounting = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,Collectors.counting()));
        System.out.println(groupingToCounting);

        System.out.println("groupingToJoing");
        var groupingToJoing = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,Collectors
                                .mapping(
                                        Movie::getTitle,
                                        Collectors.joining(","))
                        )
                );
        System.out.println(groupingToJoing);

        //--Partitioning Elements
        System.out.println("PartitioningElements");
        var PartitioningElements = movies.stream()
                .collect(
                        Collectors.partitioningBy(
                                movie -> movie.getLike()>20,
                                Collectors
                                        .mapping(
                                                Movie::getTitle,
                                                Collectors.joining(",")
                                        )
                        )
                );

        System.out.println(PartitioningElements);



















    }




}
