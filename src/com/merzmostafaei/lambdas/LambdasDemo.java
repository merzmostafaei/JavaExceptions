package com.merzmostafaei.lambdas;

import java.util.List;
import java.util.function.*;

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



    }


    public static void greet(Printer printer){
        printer.print("Hello World from greet method");
    }


    public static void ChainingConsumer(){
        List<String> list = List.of("a","b","c");
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUperCase = item -> System.out.println(item.toUpperCase());

        System.out.println("Chaining Consumer");
        list.forEach(print.andThen(printUperCase).andThen(print));
    }


    public static void FunctionInterFaces() {
        //-- Using Consumer interface
        System.out.println("Using Consumer interface");
        List<Integer> list = List.of(1, 2, 3);
        //foreach use consumer so we pass the lambrda
        list.forEach(item -> System.out.println(item));

        //-- Using Supplayer Interface
        System.out.println("Using Supplayer Interface");
        Supplier<Double> getRandom = () -> Math.random();
        var random = getRandom.get();
        System.out.println(random);

        //--Using Function Interface
        System.out.println("Using Function Interface");

        Function<String, Integer> map = str -> str.length();
        var lenght = map.apply("Sky");
        System.out.println(lenght);

        //--Compose Function
        // think we have this string and we want transform it
        // "key:Value"
        // "key=Value"
        // "{key=Value}"
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str +"}";

        //Declarative Programming
        System.out.println("use andThen in Function");
        var result = replaceColon
                .andThen(addBraces)
                .apply("key:value");

        System.out.println(result);

        System.out.println("use compose in Function");

        var result2 = addBraces.compose(replaceColon).apply("key:value");

        System.out.println(result2);

        //--Predicate Interface
        System.out.println("Predicate Interface");

        Predicate<String> isLongerThan5 = str -> str.length()>5;
        var resiltPredicate = isLongerThan5.test("sky");
        System.out.println(resiltPredicate);


    }

    public static void combiningPredicate(){
        System.out.println("CombiningPredicate");
        Predicate<String> hasLefrBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        // && || !
        Predicate<String> hasLeftAndRight = hasLefrBrace.and(hasRightBrace);
        Predicate<String> hasLeftOrRight = hasLefrBrace.or(hasRightBrace);
        Predicate<String> hasNotLeftAndRight = hasLefrBrace.negate();

        var resulthasLeftAndRight= hasLeftAndRight.test("{key:value}");
        System.out.println("resulthasLeftAndRight");
        System.out.println(resulthasLeftAndRight);
        var resulthasLeftOrRight= hasLeftOrRight.test("{key:value}");
        System.out.println("resulthasLeftOrRight");
        System.out.println(resulthasLeftOrRight);
        var resulthasNotLeftAndRight= hasNotLeftAndRight.test("{key:value}");
        System.out.println("resulthasNotLeftAndRight");
        System.out.println(resulthasNotLeftAndRight);




    }

    //Binary Operation Interface
    public static void BinaryOperation(){
        System.out.println("BinaryOperatio");
        // a, b -> a+b -> squre
        BinaryOperator<Integer> add = (a, b) -> a + b;
        Function<Integer,Integer> squre = a-> a*a;

        var result = add.andThen(squre).apply(1,2);
        System.out.println(result);
    }

    public static void UnaryOperator(){
        System.out.println("UnaryOperator");

        UnaryOperator<Integer> square = n-> n*n;
        UnaryOperator<Integer> increment = n-> n+1;

        var result = increment.andThen(square).apply(1);
        System.out.println(result);
    }

}
