package com.example.a2340anothertry.todoRecyclerStuff;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2340anothertry.R;

public class todoViewHolder extends RecyclerView.ViewHolder {
    TextView name, description, time, date;
    Button deleteButton;
    public todoViewHolder(@NonNull @org.jetbrains.annotations.NotNull View view) {
        super(view);
        name = view.findViewById(R.id.Name);
        description = view.findViewById(R.id.Description);
        time = view.findViewById(R.id.Time);
        date = view.findViewById(R.id.Date);
        deleteButton = view.findViewById(R.id.button5);
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public void setTime(TextView time) {
        this.time = time;
    }

    public void setDate(TextView date) {
        this.date = date;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public TextView getName() {
        return name;
    }

    public TextView getDescription() {
        return description;
    }

    public TextView getTime() {
        return time;
    }

    public TextView getDate() {
        return date;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
}
