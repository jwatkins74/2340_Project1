package com.example.a2340anothertry.todoRecyclerStuff;

import java.util.Date;

public class todos {
    private String Title;
    private String Description;
    private String time;
    private String date;

    public todos(String title, String description, String time, String date) {
        Title = title;
        Description = description;
        this.time = time;
        this.date = date;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

}
