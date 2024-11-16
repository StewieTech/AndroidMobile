package com.example.databasefun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {
    Context context ;
    List<Car> cars ;
    AppDatabase db;


    CarAdapter(Context context, List<Car> cars, AppDatabase db) {
        this.context = context ;
        this.cars = cars ;
        this.db = db ;

    }

    @NonNull
    @Override
    public CarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false) ;
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.MyViewHolder holder, int position) {
        holder.txtMake.setText(cars.get(position).getCarMake());
        holder.txtName.setText(cars.get(position).getCarName());

    }

    @Override
    public int getItemCount() {
        return cars.size() ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtMake ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMake = itemView.findViewById(R.id.txtMake) ;
            txtName = itemView.findViewById(R.id.txtName) ;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.carDao().deleteByMake(cars.get(getAdapterPosition()).getCarMake());
                    cars.remove(getAdapterPosition()) ;
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}
