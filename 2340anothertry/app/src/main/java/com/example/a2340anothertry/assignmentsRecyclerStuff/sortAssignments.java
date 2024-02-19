package com.example.a2340anothertry.assignmentsRecyclerStuff;
import com.example.a2340anothertry.MainActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class sortAssignments {
    public static Comparator<assignments> NameComparator = new Comparator<assignments>() {

        public int compare(assignments s1, assignments s2) {
            String Name1
                    = s1.getClass1().toUpperCase();
            String Name2
                    = s2.getClass1().toUpperCase();

            // Returning in ascending order
            return Name1.compareTo(
                    Name2);

        }
    };
    public static Comparator<assignments> DateComparator = new Comparator<assignments>() {
        DateFormat f = new SimpleDateFormat("MM/dd/yyyy");
        public int compare(assignments s1, assignments s2) {
            String Date1 = s1.getDuedate();
            String Date2 = s2.getDuedate();
            try {
                return f.parse(Date1).compareTo(f.parse(Date2));
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }
    };
}