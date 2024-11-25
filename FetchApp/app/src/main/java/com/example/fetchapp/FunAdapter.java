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
    ArrayList<Uni> unis;
    Context context;

    public FunAdapter(Context context, ArrayList<Uni> unis) {
        this.context = context;
        this.unis = unis;
    }

    @NonNull
    @Override
    public FunAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FunAdapter.MyViewHolder holder, int position) {
        holder.schoolTxtView.setText(unis.get(position).getName());
        holder.websiteTxtView.setText(unis.get(position).getWebPage());
        holder.stateTxtView.setText(unis.get(position).getStateProvince());

    }

    @Override
    public int getItemCount() {
        return unis.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView schoolTxtView, websiteTxtView, stateTxtView ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            schoolTxtView = itemView.findViewById(R.id.schoolTxtview);
            websiteTxtView = itemView.findViewById(R.id.websiteTxtView);
            stateTxtView = itemView.findViewById(R.id.stateTxtView);

        }
    }
}
