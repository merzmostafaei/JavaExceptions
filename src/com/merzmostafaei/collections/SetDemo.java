package com.merzmostafaei.collections;

import java.util.*;

public class SetDemo {
    public static void show() {
        Set<String> set = new HashSet<>();
        set.add("sky");
        set.add("is");
        set.add("Blue");
        set.add("Blue");
        set.add("Blue");
        System.out.println("set interface");
        System.out.println(set);

        //--now we ganna use the Set for Collection

        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a-collection", "b-collection", "c-collection","b-collection","b-collection");
        Set<String> setCollection = new HashSet<>(collection);
        System.out.println("Set of Collection");
        System.out.println(setCollection);

        //-- use set for list of String
        System.out.println("set for list of String");
        Set<String> setlist1 =
                new HashSet<>(Arrays.asList("a","b","c"));
        Set<String> setlist2 =
                new HashSet<>(Arrays.asList("b","c","d"));

        // Intersection
        System.out.println("Intersection -> common both sets");
        setlist1.retainAll(setlist2);
        System.out.println(setlist1);

        // Union
        System.out.println("Union  Operation +");
        setlist1.addAll(setlist2);
        System.out.println(setlist1);







    }
}
