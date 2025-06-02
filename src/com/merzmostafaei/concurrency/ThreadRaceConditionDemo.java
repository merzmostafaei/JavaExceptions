package com.merzmostafaei.concurrency;

import java.util.ArrayList;
import java.util.List;

//public class ThreadRaceConditionDemo {
//    public static void show() {
//        //--RaceCondition
//        System.out.println("RaceCondition");
//        var status = new DownloadStatus();
//        List<Thread> threads = new ArrayList<>();
//        for (
//                var i = 0;
//                i < 20; i++) {

//            var threadRace = new Thread(new DownloadFileTask(status));
//            threadRace.start();
//            //-- we can not use the join because make it main thread wait for ->
//            // each download to finish before starting to other download
//            //join method is blocking method and we nee to make list<Thread> first
//            //threadRace.join();
//            threads.add(threadRace);
//
//            // -- we need other loop for iterate with all the thread list and join with them
//        for (var thRead : threads) {
//                try {
//                    thRead.join();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//        }
//        System.out.println("getTotalBytesStatus : "+status.getTotalBytes());
//
//        }
//    }
//}