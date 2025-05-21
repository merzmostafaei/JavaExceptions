package com.merzmostafaei;

import com.merzmostafaei.exceptions.ExeptionDemo;
import com.merzmostafaei.generics.GenericList;
import com.merzmostafaei.generics.User;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        ExeptionDemo.show();
//        ExeptionDemo.catchException();
//        ExeptionDemo.TryResource();
//        try {
//            ExeptionDemo.ThrowingExceptions();
//        } catch (Throwable e) {
//            System.out.println("An unexpected error occurred");
//        }
//        ExeptionDemo.CustomException();
//        ExeptionDemo.ChainingException();

        // use GenericClas for Integer
//        var list = new GenericList<Integer>();
//        list.add(1);
//        int number = list.get(0);

        var user = new GenericList<User>();
        user.add(new User());
        User indexuser = user.get(0);

        //Constrains, that we can extract to generic type
        // can be object, or interface with subclasses
        var Constraints = new GenericList<User>();


    }
}