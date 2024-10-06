package com.example.SoccerLeagueApp;

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


public class FunAdapter extends RecyclerView.Adapter<FunAdapter.MyViewHolder> {

    String[] namePlayers;
    String[] scorePlayers;
    Context context;
    String[] serialNumbers ;
    int[] imageIcons ;
    LayoutInflater inflater;

    public FunAdapter(String[] namePlayers, String[] scorePlayers, Context context, String[] serialNumbers, int[] imageIcons) {
        this.namePlayers = namePlayers;
        this.scorePlayers = scorePlayers;
        this.context = context;
        this.serialNumbers = serialNumbers;
        this.imageIcons = imageIcons;
        inflater = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public FunAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.namePlayerTextView.setText(namePlayers[position]);
        holder.scorePlayerTextView.setText(scorePlayers[position]);
        holder.serialNumberTextView.setText(serialNumbers[position]);
        holder.playerImageView.setImageResource(imageIcons[position]);

    }



    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    
    
/*
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_row_layout, null);

        TextView namePlayerTextView = view.findViewById(R.id.viewNamePlayer);
        TextView scorePlayerTextView = view.findViewById(R.id.viewScorePlayer);
        TextView serialNumberTextView = view.findViewById(R.id.viewSerialNumber);
        ImageView playerImageView = view.findViewById(R.id.viewImageView);
        namePlayerTextView.setText(namePlayers[position]);
        scorePlayerTextView.setText(scorePlayers[position]);
        serialNumberTextView.setText(serialNumbers[position]);
        playerImageView.setImageResource(imageIcons[position]);
        return view;
    }*/


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView namePlayerTextView ;
        TextView scorePlayerTextView;
        TextView serialNumberTextView ;
        ImageView playerImageView;

        public MyViewHolder(@NonNull View view) {
            super(view);
            namePlayerTextView = view.findViewById(R.id.viewNamePlayer);
            scorePlayerTextView = view.findViewById(R.id.viewScorePlayer);
            serialNumberTextView = view.findViewById(R.id.viewSerialNumber);
            playerImageView = view.findViewById(R.id.viewImageView);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();
                    customDialog();
                }
            });
        }

    }

    void customDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null);
        alertDialog.setView(view);

        Button btnDismiss = view.findViewById(R.id.btnDismiss);
        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Try another button :) ", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.create().show();

    }
}
