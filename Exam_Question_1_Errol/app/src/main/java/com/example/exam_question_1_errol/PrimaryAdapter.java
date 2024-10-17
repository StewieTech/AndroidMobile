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

    public PrimaryAdapter(Context context, String[] nameCars, String[] modelCars) {
        this.context = context;
        this.nameCars = nameCars;
        this.modelCars = nameCars;
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
        holder.nameCar.setText(namePlayers[position]);
        holder.scorePlayerTextView.setText(scorePlayers[position]);
        holder.serialNumberTextView.setText(nameCars[position]);
        holder.playerImageView.setImageResource(imageIcons[position]);

    }



    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return namePlayers.length;
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView namePlayerTextView ;
        TextView scorePlayerTextView;
        TextView serialNumberTextView ;
        ImageView playerImageView;
        TextView nameCar ;
        TextView modelCar ;
        ImageView deleteCar ;

        public MyViewHolder(@NonNull View view) {
            super(view);
            nameCar = view.findViewById(R.id.nameCar);
            modelCar = view.findViewById(R.id.modelCar);
            deleteCar = view.findViewById(R.id.deleteCar);

            namePlayerTextView.setOnClickListener(tmp -> customDialog("You Clicked Player Name"));
            scorePlayerTextView.setOnClickListener(tmp -> customDialog("You Clicked Player Score"));
            serialNumberTextView.setOnClickListener(tmp -> customDialog("You Clicked Player Number"));
            playerImageView.setOnClickListener(tmp -> customDialog("You Clicked Player Image"));

        }

    }

    void customDialog(String outputText) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null);
        alertDialog.setView(view);

        TextView clickedDialog = view.findViewById(R.id.clickedDialog);
        Button btnDismiss = view.findViewById(R.id.btnDismiss);

        clickedDialog.setText(outputText);

        AlertDialog dialog = alertDialog.create();
        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Try another button :) ", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}

