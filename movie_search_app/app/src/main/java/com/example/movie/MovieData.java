package com.example.movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieData {

    @SerializedName("lastBuildDate")
    @Expose
    private String lastBuildDate;

    @SerializedName("total")
    @Expose
    private String total;

    @SerializedName("start")
    @Expose
    private String start;

    @SerializedName("display")
    @Expose
    private String display;

    @SerializedName("items")
    @Expose
    private MovieDataItem[] movieDataItems;


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public MovieDataItem[] getMovieDataItems() {
        return movieDataItems;
    }

    public void setMovieDataItems(MovieDataItem[] movieDataItems) {
        this.movieDataItems = movieDataItems;
    }

    @Override
    public String toString() {
        return "ClassPojo [total = " + total + ", lastBuildDate = " + lastBuildDate + ", display = " + display + ", start = " + start + ", items = " + movieDataItems + "]";
    }


}
