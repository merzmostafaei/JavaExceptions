package com.merzmostafaei.concurrency;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DownloadStatus {
    private int totalBytes;
    //private Object totalByteLock = new Object(); --> use insesd of using (this) for monitor filed

    //Synchoronized Lock

    //private Lock lock = new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }
    // use synchronized keyword like this {
//    public synchronized void incrementTotalBytes(){
//        //try{
//
//        totalBytes++;
//
    // }
    //-- OR --
//   public synchronized void incrementTotalBytes(){
      //synchronized(this);       --> if you have one filed
     //synchoronized(totalByteLock);       ---> first you need to intrudice one object filed and use it here
      //totalBytes++;
    //}
    public void incrementTotalBytes(){
        //lock.lock();
        //try{

            totalBytes++;
        //}
        //finally {
        //    lock.unlock();}
    }
}
