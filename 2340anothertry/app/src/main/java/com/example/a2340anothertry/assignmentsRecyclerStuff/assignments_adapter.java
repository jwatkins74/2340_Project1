package com.example.a2340anothertry.assignmentsRecyclerStuff;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2340anothertry.MainActivity;
import com.example.a2340anothertry.R;

import java.util.ArrayList;

public class assignments_adapter extends RecyclerView.Adapter<assignmentViewHolder> {
    Context context;
    ArrayList<assignments> assignmentList;
    private ItemClickListener clickListener;


    public assignments_adapter(ArrayList<assignments> items, Context context, ItemClickListener clickListener) {
        this.assignmentList = items;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public assignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new assignmentViewHolder(LayoutInflater.from(context).inflate(R.layout.assignment_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull assignmentViewHolder holder, int position) {
        holder.name.setText(assignmentList.get(position).getName());
        holder.date.setText(assignmentList.get(position).getDuedate());
        holder.class1.setText(assignmentList.get(position).getClass1());
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(holder.getAdapterPosition());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(assignmentList.get(holder.getAdapterPosition()));
            }
        });

    }


    @Override
    public int getItemCount() {
        return assignmentList.size();
    }

    public void removeItem(int position) {
        assignmentList.remove(position);
        MainActivity.assignments = assignmentList;
        notifyItemRemoved(position);
        if (assignmentList.isEmpty()) {
            notifyDataSetChanged();
        }
    }

    public interface ItemClickListener {
        public void onItemClick(assignments assignment);
    }
}
