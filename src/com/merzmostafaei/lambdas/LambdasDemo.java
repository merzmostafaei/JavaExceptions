package com.merzmostafaei.lambdas;

import java.util.List;

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

        //-- Using method Consumer
        List<Integer> list = List.of(1,2,3);
        //foreach use consumer so we pass the lambrda
        list.forEach(item -> System.out.println(item));
    }




    public static void greet(Printer printer){
        printer.print("Hello World from greet method");
    }
}
