package com.merzmostafaei.concurrency;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {
    public static void show(){
        System.out.println("current Thread in main :" + Thread.currentThread().getName());

        //for (var i = 0; i<3; i++){
//            Thread thread = new Thread(new DownloadFileTask());
//            thread.start();

            // we want to analyse the file after downlading
            // but we don't know current thread when is
            //finish so we make this:

            //-- Joining a Thread
            // if use this joinng you stuck in the for loop in DownloadingFile
                // in Intrrupting call
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("File is ready to be scanned");
//
//            try {
//                thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            // Interrupting a Thread
//            thread.interrupt();

        //}


    }
}
