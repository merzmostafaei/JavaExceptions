package com.merzmostafaei.concurrency;

public class DownloadFileTask implements Runnable {
    @Override
    public void run(){

        System.out.println("Downling File-" + "CurrentThreadNameDownloading:" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Downling Complite-" + "CurrentThreadNameDownloading:" + Thread.currentThread().getName());

    }
}
