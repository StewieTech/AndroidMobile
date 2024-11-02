package com.example.SoccerLeagueApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class PrimaryAdapter extends BaseAdapter {

    String[] namePlayers;
    String[] scorePlayers;
    Context context;
    String[] serialNumbers ;
    int[] imageIcons ;
    LayoutInflater inflater;

    public PrimaryAdapter(String[] namePlayers, String[] scorePlayers, Context context, String[] serialNumbers, int[] imageIcons) {
        this.namePlayers = namePlayers;
        this.scorePlayers = scorePlayers;
        this.context = context;
        this.serialNumbers = serialNumbers;
        this.imageIcons = imageIcons;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return serialNumbers.length;
    }

    @Override
    public Object getItem(int position) {
        return serialNumbers[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
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


    }


}
