package com.merzmostafaei.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T extends  Comparable & Cloneable> {
    @SuppressWarnings("unchecked")
    private List<T> items = new ArrayList<>();
//    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item){
        items.set(count++, item);
    }
    public T get(int index){
        return items.get(index);
    }
}
