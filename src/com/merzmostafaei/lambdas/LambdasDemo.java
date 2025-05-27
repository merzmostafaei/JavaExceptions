package com.merzmostafaei.lambdas;

public class LambdasDemo {
    public static void show(){
        greet(new ConsolePrinter());
    }

    public static void greet(Printer printer){
        printer.print("Hello World from greet method");
    }
}
