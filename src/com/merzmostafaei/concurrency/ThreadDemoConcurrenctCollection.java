package com.merzmostafaei.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadDemoConcurrenctCollection {
    public static void show(){
        //Map<Integer,String> map = new HashMap<>();
        Map<Integer,String> map = new ConcurrentHashMap<>(); //implement program against interface

        map.put(1,"a");
        map.get(1);
        map.remove(1);
    }
}
