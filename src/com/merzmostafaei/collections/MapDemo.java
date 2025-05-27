package com.merzmostafaei.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
    public static void show(){
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");
        Map<String,Customer> map = new HashMap<>();
        map.put(c1.getEmail(),c1);
        map.put(c2.getEmail(),c2);

        System.out.println("use Hashmap to get customer");

        var customer = map.get("e1");
        System.out.println(customer);

        var customer2 = map.get("e10");
        System.out.println(customer2);

        // -- use Defult
        System.out.println("use Defult for unkown");
        var unknown = new Customer("Unknown","");
        var customerDefult = map.getOrDefault("e10", unknown);
        System.out.println(customerDefult);

        // -- use containskey  return boolian
        System.out.println("use containskey ");
        var customerContainkey = map.containsKey("e20");
        System.out.println(customerContainkey);

        //--Replaceing
        System.out.println("Replaceing");
        var replace = map.replace("e1",new Customer("a++","e20"));
        System.out.println(replace);
        System.out.println("see entier map");
        System.out.println(map);

        // how to use for in map?

        System.out.println("use for in map ");
        System.out.println("keyset");

        for (var keyset : map.keySet()){
            System.out.println(keyset);

        }


        System.out.println("enterySet");
        for (var entry : map.entrySet()){
            System.out.println(entry);
            System.out.println(entry.getValue());
        }

        System.out.println(".values give collection of customer and order not garenti ");

        for (var customerfor : map.values()){
            System.out.println(customerfor);

        }






    }
}
