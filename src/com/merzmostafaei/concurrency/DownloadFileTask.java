package com.merzmostafaei.concurrency;

public class DownloadFileTask implements Runnable {
    @Override
    public void run(){

        System.out.println("Downling File" + "CurrentThreadNameDownloading:" + Thread.currentThread().getName());
    }
}
