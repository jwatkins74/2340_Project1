package com.example.a2340anothertry.classRecyclerStuff;

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

import java.sql.Time;
import java.util.ArrayList;
import java.util.Locale;

public class classes_adapter extends RecyclerView.Adapter<ClassViewHolder> {
    Context context;
    ArrayList<classes> classList;

    public classes_adapter( ArrayList<classes> items, Context context) {

        this.classList = items;
        this.context = context;
    }


    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClassViewHolder(LayoutInflater.from(context).inflate(R.layout.class_layout,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        holder.name.setText(classList.get(position).getName());

        String time = classList.get(position).getTime();

        holder.time.setText(time);
        holder.location.setText(classList.get(position).getLocation());
        holder.professor.setText(classList.get(position).getProfessor());

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
        return classList.size();
    }

    public void removeItem(int position) {
        classList.remove(position);
        MainActivity.classes1 = classList;
        notifyItemRemoved(position);
        if (classList.isEmpty()) {
            notifyDataSetChanged();
        }
    }
}
