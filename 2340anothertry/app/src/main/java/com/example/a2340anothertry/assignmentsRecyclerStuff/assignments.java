package com.example.a2340anothertry.assignmentsRecyclerStuff;

import androidx.annotation.Nullable;

import com.example.a2340anothertry.classRecyclerStuff.classes;

public class assignments {
    private String Name;
    private String class1;
    private String duedate;

    public assignments(String name, String class1, String duedate) {
        Name = name;
        this.class1 = class1;
        this.duedate = duedate;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getName() {
        return Name;
    }

    public String getClass1() {
        return class1;
    }

    public String getDuedate() {
        return duedate;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return this.Name.equals(((assignments) obj).getName()) && this.class1.equals(((assignments) obj).getClass1()) && this.duedate.equals(((assignments) obj).getDuedate());
    }
}
