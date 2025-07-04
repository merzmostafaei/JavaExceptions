package com.merzmostafaei;

import com.merzmostafaei.collections.*;
//import com.merzmostafaei.concurrency.ConfinementDemo;
import com.merzmostafaei.concurrency.*;
//import com.merzmostafaei.concurrency.ThreadRaceConditionDemo;
import com.merzmostafaei.executors.*;
import com.merzmostafaei.generics.*;
import com.merzmostafaei.lambdas.LambdasDemo;
import com.merzmostafaei.streams.CreatingStreamsDemo;
import com.merzmostafaei.streams.StreamDemo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        ExeptionDemo.show();
//        ExeptionDemo.catchException();
//        ExeptionDemo.TryResource();
//        try {
//            ExeptionDemo.ThrowingExceptions();
//        } catch (Throwable e) {
//            System.out.println("An unexpected error occurred");
//        }
//        ExeptionDemo.CustomException();
//        ExeptionDemo.ChainingException();

        // use GenericClas for Integer
//        var list = new GenericList<Integer>();
//        list.add(1);
//        int number = list.get(0);

//        var user = new GenericList<User>();
//        user.add(new User());
//        User indexuser = user.get(0);

        //--Constrains, that we can extract to generic type
        // --can be object, or interface with subclasses
//        var Constraints = new GenericList<User>();

        // ComparableInterface
        var user1 = new UserComparable(10);
        var user2 = new UserComparable(20);
        if (user1.compareTo(user2) < 0)
            System.out.println("user1 < user2");
        else if (user1.compareTo(user2) == 0)
            System.out.println("user1 == user2");
        else System.out.println("user1 > user2");


        // --Generic Method
        var max = Utils.max(new UserComparable(10), new UserComparable(20));
        // --ovveride tostring in usercomparbleclass
        System.out.println(max);

        //-- multiparameter
        Utils.print(1, "merz");
        Utils.print(new User(), "merz");
        var keyvaluepair = new KeyValuePair<>();


        // -- because Instructor is the child of Usercomparable
        UserComparable user = new Instructor(10);
        Utils.printUser(new Instructor(20));

        // -- for list of users
//        var instructors = new GenericList<Instructor>();
        // ! Generic child is not subclass of Generic the Parents
//        var users = new GenericList<UserComparable>();
//        Utils.printUsers(users);
//        Utils.printUser(new Instructor(20));
//        Utils.printUsers(new GenericList<UserComparable>());


        // ---Iterable Interface
        // insest of for and change the private implimentation to public we use itable

        var list = new com.merzmostafaei.collections.GenericList<String>();
//        var iterator = list.iterator();
//        while (iterator.hasNext()){
//            var current = iterator.next();
//            System.out.println(current);
//        }
        // -- see the ByteCode representation
        list.add("a");
        list.add("B");
        for (var item : list)
            System.out.println(item);
        //-- for here use iterator when we applay implements Iterable<T> in our class
        //-- if we delete this part foreach not applicable to type of our class.

        //-----------------------
        // -- Collections

        CollectionsDemo.show();

        //-- List

        ListDemo.show();

       //-- Comparable Interface


         List<Customer> customers = new ArrayList<>();
         customers.add(new Customer("Camparable B","e3"));
         customers.add(new Customer("Camparable A","e2"));
         customers.add(new Customer("Camparable C","e1"));
         //-- Sorting List
        System.out.println("customers in comparable interface");
        //sort by name, use first sort<List<T>>
        Collections.sort(customers);
        System.out.println("  //sort by name, use first sort<List<T>>");
        System.out.println(customers);

        //sort by email, use second sort<list<T>,Comparator>
        Collections.sort(customers, new EmailComparator());

        System.out.println("//sort by email, use second sort<list<T>,Comparator>");
        System.out.println(customers);


        // Queue Interface

        QueueDemo.show();

        //-- Set Interface
        SetDemo.show();

        //-- Hashmap
        // ! Hashmap is not Collection and Iterable

        MapDemo.show();


        //--Lambdas
        LambdasDemo.show();

        //--Chaning consumer
        LambdasDemo.ChainingConsumer();


        //--FunctionInterfaces
        LambdasDemo.FunctionInterFaces();

        //Combining Predicate Interface
        LambdasDemo.combiningPredicate();

        //BinaryOperator
        LambdasDemo.BinaryOperation();

        //UnaryOperator
        LambdasDemo.UnaryOperator();

        //--Stream
        StreamDemo.show();

        //CreatingStream
        CreatingStreamsDemo.show();

        //--Concurrency and Multi-threading

        System.out.println("ThreadRun :"+Thread.activeCount());
        System.out.println("Thread avalible"+Runtime.getRuntime().availableProcessors());

        //--Starting Thread
        ThreadDemo.show();

        //--RaceCondition
        //ThreadRaceConditionDemo.show();

        //-- ConfienmentDemo
        //ConfinementDemo.show();

        //--Volatile keyvord
        ThreadDemoWithVolatile.show();

        //--Atomic Object
        //--Changing the DownloadStatus Field
        ThreadDemo.show();

        //--synchronized Collection
        ThreadDemoSynchronizedCollection.show();

        //--Executor
        //ExecutorsDemo.show();

        //--Callable And Futures
        //ExecutorsDemo.show();

        //--CompletableFuture
        CompletableFuturesDemo.show();

        // --Implementing and Asynchronous API
        var service = new MailService();
        service.sendAsync();
        System.out.println("Hello World ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //-- Running Code on Completion

        ExecutorsDemo.Comletion();

        //--Handling Exceptions
        HandelingFutureExceptions.show();

        //--Transforming a Completable Future

        TransformingACompletableFuture.show();

        //--ComposingCompletableFuture

        ComposingCompletableFutures.show();

        //--CombiningCompletableFuture
        CombiningCompletableFuture.show();

        //--Waiting for Many Tasks to Complete
        CombiningCompletableFuture.manyTask();

        //Waiting For the First Task
        //Use For Slow Service
        CombiningCompletableFuture.Taskdelay();

        //--HandelingTimeOuts
        HandelingTimeOuts.show();

        //--BestPriceFinder Practice
        com.merzmostafaei.PriceFinderPractice.CompletableFuturesDemo.show();
    }


}