package com.example.a2340anothertry.assignmentsRecyclerStuff;

import java.util.ArrayList;
import java.util.Collections;

public class sortAssignmentsDeclaration {
    public ArrayList<assignments> sortAssignmentByName(ArrayList<assignments> ArrayList) {
        Collections.sort(ArrayList, sortAssignments.NameComparator);
        return ArrayList;
    }
    public ArrayList<assignments> sortAssignmentByDate(ArrayList<assignments> ArrayList) {
        Collections.sort(ArrayList, sortAssignments.NameComparator);
        return ArrayList;
    }
}
