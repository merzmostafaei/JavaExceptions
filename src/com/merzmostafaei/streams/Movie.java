package com.merzmostafaei.streams;

public class Movie implements Comparable{
    private String title;

    private int like;

    private Genre genre;


    public Movie(String title, int like, Genre genre) {
        this.title = title;
        this.like = like;
        this.genre = genre;
    }

    public int getLike() {
        return like;
    }

    public String getTitle() {
        return title;
    }


    public Genre getGenre() {
        return genre;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    @Override
    public String toString() {
        return "Movie{title='" + title + "', like=" + like + "}";
    }
}
