package com.merzmostafaei.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//NullPointerException
public class ExeptionDemo {
    public static void show(){
        sayHello(null);
    }

    public static void sayHello(String name){
        System.out.println(name.toUpperCase());
    }
//    public static void catchException(){
//        FileReader reader = null ; // beacuse Filereader not gonna executet
//        try
//
//        {
//            reader = new FileReader("file.txt");
//            System.out.println("File opend");
//            var value = reader.read();
//            new SimpleDateFormat().parse("");
//            //reader.close(); if put here if in excepion not gonna excute
//        }
//        catch (FileNotFoundException ex) {
//            System.out.println("File not exist");
//            System.out.println(ex.getMessage());
//        }
//
//        catch (IOException | ParseException ex) {
//            System.out.println("File not can read");
//            System.out.println(ex.getMessage());
//        }
//        finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
    public static void TryResource() {
        try (  FileReader reader =new FileReader("file.txt");
                FileReader reader1 = new FileReader("File.txt");

                )
            {

                System.out.println("File opend");
                var value = reader.read();
                new SimpleDateFormat().parse("");
                //reader.close(); if put here if in excepion not gonna excute
            }
        catch(FileNotFoundException ex){
                System.out.println("File not exist");
                System.out.println(ex.getMessage());
            }

        catch(IOException | ParseException ex){
                System.out.println("File not can read");
                System.out.println(ex.getMessage());
            }
        }
    public static void ThrowingExceptions() throws IOException {
        var account = new Account();
        try {
            account.deposit(-1);
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println("Logging");
//            //Re Throwing Exception
            throw e;
        }
    }

//    public static void CustomException(){
//        var account1 = new Account();
//        try {
//            account1.withdraw(10);
//        } catch (InsufficientFundsException e) {
//            System.out.println(e.getMessage());;
//        }
//    }
    public static void ChainingException(){
        var account1 = new Account();
        try {
            account1.withdraw(10);
        } catch (AccountException e) {
//            e.printStackTrace(); --if you want to make library or for other programmer
            // -- for user freindly make this is less noisy.
           var cause = e.getCause();
            System.out.println(cause.getMessage());

        }
    }


    }

