package com.merzmostafaei.concurrency;

public class DownloadFileTask implements Runnable {


    private final DownloadStatus status;

//-- use For ConfinementDemo
    //    public DownloadFileTask() {
//        this.status = new DownloadStatus();
//
//    }
    public DownloadFileTask(DownloadStatus status) {
       this.status = status;
     }



    @Override
    public void run(){

        System.out.println("Downling File-" + "CurrentThreadNameDownloading:" + Thread.currentThread().getName());
        for (var i = 0; i< 10_000; i++){
            // if we don't add this line is not gonna execute
            if(Thread.currentThread().isInterrupted()) return;
            System.out.println("DownloadingByte"+i);
            status.incrementTotalBytes();
        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        status.setDone(); // use for volatile
        synchronized (status){
            status.notifyAll(); //when use wait for status object

        }

        System.out.println("Downling Complite-" + "CurrentThreadNameDownloading:" + Thread.currentThread().getName());

    }

    public DownloadStatus getStatus() {
        return status;
    }
}
