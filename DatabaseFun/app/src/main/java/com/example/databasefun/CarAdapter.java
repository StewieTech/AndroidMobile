package com.example.databasefun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {
    Context context ;
    String[] cars ;


    CarAdapter(Context context, String[] cars) {
        this.context = context ;
        this.cars = cars ;
    }

    @NonNull
    @Override
    public CarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false) ;
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.MyViewHolder holder, int position) {
        holder.txtMake.setText(cars[position]) ;

    }

    @Override
    public int getItemCount() {
        return cars.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMake = itemView.findViewById(R.id.txtMake) ;
            txtName = itemView.findViewById(R.id.txtName) ;
        }
    }
}
