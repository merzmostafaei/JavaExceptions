//package com.merzmostafaei.concurrency;
//
//import java.util.ArrayList;
//import java.util.List;
//
////--Confinement Strategy = { make every DownloadFileTask has OWN Status}
//
//public class ConfinementDemo {
//    public static void show(){
//        List<Thread> threads = new ArrayList<>();
//        //-- we use List of Download the task because wen i use it in Thread
//        //-- we don't have access it later
//        List<DownloadFileTask> tasks = new ArrayList<>();
//
//
//        for (var i = 0; i<10; i++) {
//            var task = new DownloadFileTask();
//            tasks.add(task);
//
//            Thread thread = new Thread(task);
//
//            thread.start();
//            threads.add(thread);
//        }
//        for (var thread : threads){
//            try {
//                //use for finish every Thread
//                thread.join();
//
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        //--Combining TotalBytes accross this Tasks
//        var totalBytes = tasks.stream()
//                .map(t->t.getStatus().getTotalBytes())
//                .reduce(0,Integer::sum);
//        System.out.println(totalBytes);
//    }
//}
