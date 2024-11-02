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
        return namePlayers.length;
    }

    
    

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
