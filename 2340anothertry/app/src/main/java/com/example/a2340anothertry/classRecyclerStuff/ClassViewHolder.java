package com.example.a2340anothertry.classRecyclerStuff;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2340anothertry.R;

public class ClassViewHolder extends RecyclerView.ViewHolder{
    TextView name, location, time, professor;
    Button deleteButton;
    public ClassViewHolder(@NonNull @org.jetbrains.annotations.NotNull View view) {
        super(view);
        name = view.findViewById(R.id.Name);
        location = view.findViewById(R.id.Location);
        time = view.findViewById(R.id.Time);
        professor = view.findViewById(R.id.Professor);
        deleteButton = view.findViewById(R.id.button5);
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public void setLocation(TextView location) {
        this.location = location;
    }

    public void setTime(TextView time) {
        this.time = time;
    }

    public void setProfessor(TextView professor) {
        this.professor = professor;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public TextView getName() {
        return name;
    }

    public TextView getLocation() {
        return location;
    }

    public TextView getTime() {
        return time;
    }

    public TextView getProfessor() {
        return professor;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
}
