package com.example.testinglagi.model;

public class Movie {
    private String title, poster, overview;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Movie(String title, String poster, String overview) {
        this.title = title;
        this.poster = poster;
        this.overview = overview;
    }
}
