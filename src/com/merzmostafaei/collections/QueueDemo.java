package com.merzmostafaei.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void show(){
        Queue<String> queue = new ArrayDeque<>();
        // 4 - > 3 -> 2 -> 1
        queue.add("queue1");
        queue.add("queue2");
        queue.add("queue3");
        //"queue get full offer method return false but add go throws the exception "

        queue.offer("queue4");


        //calling the peek method, calling object in front of the queue
        var front = queue.peek();
        System.out.println(front);
        System.out.println("queue is empty --> null");

        // peek return null if queue is empty
        // element return on Exception

        var front2 = queue.element();
        System.out.println(front2);
        System.out.println("queue is empty --> Exception");

        //Remove  and poll  remove items from Front
        //Diffrance {if queue is Empty }
        //Remove --> throw Exceptions
        //poll -->  return null
        var Remove = queue.remove();
        System.out.println("remove use Remove");
        System.out.println(Remove);


        var Poll = queue.poll();
        System.out.println("remove use poll");
        System.out.println(Poll);

        System.out.println("showing what we have in queue");
        var front3 = queue.peek();
        System.out.println(front3);

    }
}
