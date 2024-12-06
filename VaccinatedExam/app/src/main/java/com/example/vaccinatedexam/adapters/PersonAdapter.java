package com.example.vaccinatedexam.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class PersonViewHolder extends  RecyclerView.ViewHolder{
        TextView firstname, lastname, gender;
        ImageView vaccinationImage;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
