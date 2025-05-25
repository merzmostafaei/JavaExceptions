package com.merzmostafaei.generics;

public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second)< 0) ? second : first;
    }
    public static <K,V> void print(K key , V value){
        System.out.println(key + "=" + value);
    }

    public static void printUser(UserComparable user){
        System.out.println(user);
    }
// -- class CAP#1 {}
    // for using wildcadd
    // extend for user child ---->get
    public static void printUsers(GenericList<? extends UserComparable> users){
        Object x = users.get(0);
        System.out.println(users);
    }
    // super for user parent --- > add
    public static void printUsersAdd(GenericList<? super UserComparable> users){
        users.add(new Instructor(1));
        users.add(new UserComparable(20));
    }
}
