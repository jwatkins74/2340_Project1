package com.example.a2340anothertry.todoRecyclerStuff;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2340anothertry.MainActivity;
import com.example.a2340anothertry.R;
import com.example.a2340anothertry.examRecyclerStuff.ExamViewHolder;
import com.example.a2340anothertry.examRecyclerStuff.exams;

import java.util.ArrayList;
import java.util.Locale;

public class todo_adapter extends RecyclerView.Adapter<todoViewHolder> {
    Context context;
    ArrayList<todos> todoList;

    public todo_adapter( ArrayList<todos> items, Context context) {

        this.todoList = items;
        this.context = context;
    }


    @NonNull
    @Override
    public todoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new todoViewHolder(LayoutInflater.from(context).inflate(R.layout.todo_layout,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull todoViewHolder holder, int position) {
        holder.name.setText(todoList.get(position).getTitle());

        String time = todoList.get(position).getTime();

        holder.time.setText(time);
        holder.description.setText(todoList.get(position).getDescription());
        holder.date.setText(todoList.get(position).getDate());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the removeItem method in the adapter to remove the item
                removeItem(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public void removeItem(int position) {
        todoList.remove(position);
        MainActivity.todoList = todoList;
        notifyItemRemoved(position);
        if (todoList.isEmpty()) {
            notifyDataSetChanged();
        }
    }
}
