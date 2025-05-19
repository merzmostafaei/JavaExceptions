package com.merzmostafaei.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public static void catchException(){
        FileReader reader = null ; // beacuse Filereader not gonna executet
        try

        {
            reader = new FileReader("file.txt");
            System.out.println("File opend");
            var value = reader.read();
            new SimpleDateFormat().parse("");
            //reader.close(); if put here if in excepion not gonna excute
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not exist");
            System.out.println(ex.getMessage());
        }

        catch (IOException | ParseException ex) {
            System.out.println("File not can read");
            System.out.println(ex.getMessage());
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
