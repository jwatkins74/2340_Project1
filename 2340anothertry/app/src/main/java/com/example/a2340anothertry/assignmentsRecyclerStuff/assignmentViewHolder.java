package com.example.a2340anothertry.assignmentsRecyclerStuff;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2340anothertry.R;

public class assignmentViewHolder extends RecyclerView.ViewHolder {
    TextView name, class1, date;
    Button deleteButton;
    Button editButton;
    public assignmentViewHolder(@NonNull @org.jetbrains.annotations.NotNull View view) {
        super(view);
        name = view.findViewById(R.id.Name);
        class1 = view.findViewById(R.id.Location);
        date = view.findViewById(R.id.date);
        deleteButton = view.findViewById(R.id.button5);
        view.setClickable(true);
    }

}
