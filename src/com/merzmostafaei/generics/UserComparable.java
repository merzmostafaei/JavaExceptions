package com.merzmostafaei.generics;

public class UserComparable implements Comparable<UserComparable> {
    public int points;

    public UserComparable(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(UserComparable other) {
        // this < 0 --> -1
        // this == 0 --> 0
        // this > 0 --> 1
        return points - other.points;
    }

    @Override
    public String toString(){
        return "points = " + points;
    }
}
