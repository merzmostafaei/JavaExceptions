package com.merzmostafaei.concurrency;

public class ThreadDemo {
    public static void show(){
        System.out.println("current Thread in main :" + Thread.currentThread().getName());

        for (var i = 0; i<10; i++){
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();

            // we want to analyse the file after downlading
            // but we don't know current thread when is
            //finish so we make this:
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("File is ready to be scanned");
        }
    }
}
