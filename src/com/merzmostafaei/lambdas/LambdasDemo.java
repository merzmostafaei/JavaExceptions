package com.merzmostafaei.lambdas;

public class LambdasDemo {
    public static void show(){
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
    }

    public static void greet(Printer printer){
        printer.print("Hello World from greet method");
    }
}
