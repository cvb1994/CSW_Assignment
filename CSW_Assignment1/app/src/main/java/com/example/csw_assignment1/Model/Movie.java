package com.example.csw_assignment1.Model;

public class Movie {
    private String title;
    private int cover;

    public Movie() {
    }

    public Movie(String title, int cover) {
        this.title = title;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }
}
