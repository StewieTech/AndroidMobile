package com.example.exam_question_1_errol;


import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class PrimaryAdapter extends RecyclerView.Adapter<PrimaryAdapter.MyViewHolder> {

    Context context;
    List<String> nameCars;
    List<String> modelCars;
    LayoutInflater inflater;

    public PrimaryAdapter(Context context, List<String> nameCars, List<String> modelCars) {
        this.context = context;
        this.nameCars = nameCars;
        this.modelCars = modelCars;
        inflater = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public PrimaryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameCar.setText(nameCars.get(position));
        holder.modelCar.setText(modelCars.get(position));
        holder.deleteCar.setOnClickListener(tmp -> {
            int deletePosition = holder.getAdapterPosition();
            nameCars.remove(deletePosition);
            modelCars.remove(deletePosition);

            notifyItemRemoved(deletePosition);
            notifyItemRangeChanged(deletePosition, nameCars.size());
        });
    }




    @Override
    public int getItemCount() {
        return nameCars.size() ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameCar ;
        TextView modelCar ;
        ImageView deleteCar ;

        public MyViewHolder(@NonNull View view) {
            super(view);
            nameCar = view.findViewById(R.id.nameCar);
            modelCar = view.findViewById(R.id.modelCar);
            deleteCar = view.findViewById(R.id.deleteCar);

        }
    }

}

