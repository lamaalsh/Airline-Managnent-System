package com.example.lamafirstproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList exp_id, course_name_id;

    public MyAdapter(Context context, ArrayList exp_id, ArrayList course_name_id) {
        this.context = context;
        this.exp_id = exp_id;
        this.course_name_id = course_name_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.entry, parent, false);

        return new MyViewHolder(v);
    }

    @Override

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.course_id.setText(String.valueOf(course_name_id.get(position)));
        holder.exp_id.setText(String.valueOf(exp_id.get(position)));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, confirm.class);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return course_name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView course_id, exp_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            course_id=itemView.findViewById(R.id.course);
            exp_id=itemView.findViewById(R.id.exp);

        }
    }
}
