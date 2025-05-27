package com.merzmostafaei.collections;



public class Customer implements Comparable<Customer>{
        private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
    @Override
    public int compareTo(Customer other) {
        //this < other -> -1
        //this > other ->  1
        //this = other ->  0
        // we can't use if(name < other.name)
        // because comparable interface just apply for numbers an characters
        return name.compareTo(other.name);



    }

    @Override
    public String toString() {
        return name;
    }
}
