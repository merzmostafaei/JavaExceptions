package com.merzmostafaei.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
    public static void show(){
        //From Colletion
        System.out.println("From Colletion");
        Collection<Movie> x = List.of(new Movie("E",40),new Movie("F",50)
        );
        var counterlike = x.stream().filter(n-> n.getLike()>30).count();
        System.out.println(counterlike);


        //From List
        System.out.println("From List");
        var list = new ArrayList<>();
        list.add(0,"G");
        list.add(1,"F");
        var counterarrays = list.stream().count();
        System.out.println(counterarrays);

        //From Array
        System.out.println("From Array");
         int[] numbers={1,2,3};
        Arrays.stream(numbers)
                .forEach(n-> System.out.println(n));

        //From arbitrynumber of objects
        System.out.println("From arbitrynumber of objects");
//        Stream.of(1,2,3,4);
        Stream
                .generate(()-> Math.random())
                .limit(3).
                forEach(n-> System.out.println(n));

        //From infinite or finalstream us Itrate
        System.out.println("/From infinite or finalstream us Itrate");
        Stream
                .iterate(1,n->n+1)
                .limit(3)
                .forEach(n-> System.out.println(n));
    }
}
