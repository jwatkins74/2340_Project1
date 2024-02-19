package com.example.a2340anothertry.examRecyclerStuff;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2340anothertry.R;

public class ExamViewHolder extends RecyclerView.ViewHolder {
    TextView name, location, time, date;
    Button deleteButton;
    public ExamViewHolder(@NonNull @org.jetbrains.annotations.NotNull View view) {
        super(view);
        name = view.findViewById(R.id.Name);
        location = view.findViewById(R.id.Location);
        time = view.findViewById(R.id.Time);
        date = view.findViewById(R.id.date);
        deleteButton = view.findViewById(R.id.button5);
    }

    public TextView getDate() {
        return date;
    }

    public void setDate(TextView date) {
        this.date = date;
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

    public void setName(TextView name) {
        this.name = name;
    }

    public void setLocation(TextView location) {
        this.location = location;
    }

    public void setTime(TextView time) {
        this.time = time;
    }
}
