package com.example.fetchapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FunAdapter extends RecyclerView.Adapter<FunAdapter.MyViewHolder> {
    ArrayList<School> schools;
    Context context;

    public FunAdapter(Context context, ArrayList<School> schools) {
        this.context = context;
        this.schools = schools;
    }

    @NonNull
    @Override
    public FunAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FunAdapter.MyViewHolder holder, int position) {
        holder.schoolTxtView.setText(schools.get(position).getName());
        holder.websiteTxtView.setText(schools.get(position).getWebPage());
        holder.stateTxtView.setText(schools.get(position).getStateProvince());

    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView schoolTxtView, websiteTxtView, stateTxtView ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            schoolTxtView = itemView.findViewById(R.id.SchoolTxtview);
            websiteTxtView = itemView.findViewById(R.id.websiteTxtView);
            stateTxtView = itemView.findViewById(R.id.stateTxtView);

        }
    }
}
