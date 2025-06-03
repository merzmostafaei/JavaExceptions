package com.merzmostafaei.concurrency;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DownloadStatus {
    //private int totalBytes;
// FOR use Atomic Object
   // private AtomicInteger totalBytes = new AtomicInteger();
// For Adder
    private LongAdder totalBytes = new LongAdder();
    private volatile boolean isDone;

    //private Object totalByteLock = new Object(); --> use insesd of using (this) for monitor filed

    //Synchoronized Lock

    //private Lock lock = new ReentrantLock();
    public int getTotalBytes() {
        //return totalBytes;
        //return totalBytes.get(); //AtomicObject
        return totalBytes.intValue(); // Adder
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

           // totalBytes++;
            //totalBytes.incrementAndGet(); //AtomicIncrement
            totalBytes.increment(); //adder
        //}
        //finally {
        //    lock.unlock();}
    }
    public boolean isDone() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }
}
