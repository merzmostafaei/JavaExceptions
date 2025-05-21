package com.merzmostafaei;

import com.merzmostafaei.exceptions.ExeptionDemo;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        ExeptionDemo.show();
//        ExeptionDemo.catchException();
//        ExeptionDemo.TryResource();
        try {
            ExeptionDemo.ThrowingExceptions();
        } catch (Throwable e) {
            System.out.println("An unexpected error occurred");
        }
    }
}