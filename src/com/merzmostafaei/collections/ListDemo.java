package com.merzmostafaei.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void show() {
        List<String> list = new ArrayList<>();
        // use collection for add
        Collections.addAll(list,"list A","list B","list A");
        list.add(0,"!");
        System.out.println(list);
        System.out.println(list.get(0));
        list.set(0, "A+");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.indexOf("list B"));
        System.out.println(list.indexOf("A+"));
        System.out.println(list.lastIndexOf("list A"));

        System.out.println(list.subList(0,2));




    }



}
