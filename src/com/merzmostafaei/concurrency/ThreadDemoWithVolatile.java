package com.merzmostafaei.concurrency;
// use Volatile keyboard to tell java this Fild is temporary and gonna change
//we gonna make the isDone Fild to check for this example
// we add the (setDone() for isdone fild )  in DownloadFiletask aswell.
public class ThreadDemoWithVolatile {
    public static void show(){
        var status = new DownloadStatus();

        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(() -> {
           while (!status.isDone()){
               try {
                   Thread.sleep(10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();


    }
}
