package com.merzmostafaei.lambdas;

import java.util.List;
import java.util.function.Consumer;

public class LambdasDemo {
    // Variable Capture
    public static String prefix = "-";
    public static void show() {


//        if you use this you must create class
        //        greet(new ConsolePrinter());

        // -- use Annanimous insest of making ConsolPrinter class
        System.out.println("use Annanimous inner Class");
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);

            }
        });

        //-- using Lambda exprecion
        // 1- greet((String message) -> System.out.println(message));
         greet(message -> System.out.println(message));

        // lambda exprecion is esssensianly is object, you can do this like..
        Printer printer = message -> System.out.println(prefix + message);


        //-- method Refrance

        //Class(Object::method)
        greet(System.out::println);

        //-- Using Consumer interface
        List<Integer> list = List.of(1,2,3);
        //foreach use consumer so we pass the lambrda
        list.forEach(item -> System.out.println(item));

        // i

    }
    public static void ChainingConsumer(){
        List<String> list = List.of("a","b","c");
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUperCase = item -> System.out.println(item.toUpperCase());

        System.out.println("Chaining Consumer");
        list.forEach(print.andThen(printUperCase).andThen(print));
    }




    public static void greet(Printer printer){
        printer.print("Hello World from greet method");
    }
}
