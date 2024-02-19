package com.example.a2340anothertry.examRecyclerStuff;

import java.util.List;
import java.util.Date;
public class exams {
    private String time;
    private String date;
    String location;
    String name;

    public exams(String time, String date, String location, String name) {
        this.time = time;
        this.date = date;
        this.location = location;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}
