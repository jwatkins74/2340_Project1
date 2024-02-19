package com.example.a2340anothertry.examRecyclerStuff;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2340anothertry.MainActivity;
import com.example.a2340anothertry.R;

import java.util.ArrayList;
import java.util.Locale;

public class exam_adapter extends RecyclerView.Adapter<ExamViewHolder> {

    Context context;
    ArrayList<exams> examsList;

    public exam_adapter( ArrayList<exams> items, Context context) {

        this.examsList = items;
        this.context = context;
    }


    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExamViewHolder(LayoutInflater.from(context).inflate(R.layout.exam_layout,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        holder.name.setText(examsList.get(position).getName());
        holder.time.setText(examsList.get(position).getTime());
        holder.location.setText(examsList.get(position).getLocation());
        holder.date.setText(examsList.get(position).getDate());

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
        return examsList.size();
    }

    public void removeItem(int position) {
        examsList.remove(position);
        MainActivity.examList = examsList;
        notifyItemRemoved(position);
        if (examsList.isEmpty()) {
            notifyDataSetChanged();
        }
    }
}
