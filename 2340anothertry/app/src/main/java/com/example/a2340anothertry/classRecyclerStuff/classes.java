package com.example.a2340anothertry.classRecyclerStuff;

import java.sql.Time;

public class classes {
    private String time;
    private String location;
    private String name;
    private String professor;

    public classes(String time, String location, String name, String professor) {
        this.time = time;
        this.location = location;
        this.name = name;
        this.professor = professor;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getProfessor() {
        return professor;
    }
}
