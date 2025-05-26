package com.merzmostafaei.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show(){
        Collection<String> collection = new ArrayList<>();
//        collection.add("c --> CollectionsDemo");
//        collection.add("d --> CollectionsDemo");
       collection.add("add one by one --> CollectionsDemo");
        System.out.println(collection);
//        for (var item : collection)
//            System.out.println(item);
        //---- ADD more multiple element in one go insest of doing .add

        Collections.addAll(collection,"c --> CollectionsDemo","d --> CollectionsDemo");
        System.out.println(collection);
        System.out.println(collection.size());
        collection.remove("c --> CollectionsDemo");
        System.out.println(collection);
        System.out.println(collection.size());
        //contains element must to save in variable because is abstrac
        var containsC = collection.contains("c --> CollectionsDemo");
        System.out.println(containsC);
        //-- Convert To regular Array
        Object[] objectsArray = collection.toArray();
        // objectsArray[0]; -- need convert collection to string


        String[] stringArray = collection.toArray(new String[0]);
        System.out.println(stringArray[0].toUpperCase());

        // Remove all Items
        collection.clear();
        System.out.println(collection);
        //verify that
        System.out.println(collection.isEmpty());

        // -- For Equality
        Collection<String> other = new ArrayList<>();
        other.addAll(collection);
        System.out.println("collection == othe");
        System.out.println(collection == other); // diffrent object in memory
        System.out.println("collection.equals(other)");
        System.out.println(collection.equals(other));




    }
}
