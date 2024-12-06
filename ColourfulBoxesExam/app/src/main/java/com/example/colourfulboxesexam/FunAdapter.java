package com.example.colourfulboxesexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FunAdapter extends RecyclerView.Adapter<FunAdapter.ViewHolder> {
    private Context context ;

    public FunAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FunAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FunAdapter.ViewHolder holder, int position) {

        int colourBoxes;
        switch (position % 4) {
            case 0:
                colourBoxes = R.color.purple;
                break;
            case 1:
                colourBoxes = R.color.green;
                break;
            case 2:
                colourBoxes = R.color.orange;
                break;
            default:
                colourBoxes = R.color.red;
                break;
        }

        holder.cardBoxColour.setBackgroundColor(ContextCompat.getColor(context, colourBoxes));


    }

    @Override
    public int getItemCount() {
        return 32;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardBoxColour;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardBoxColour = itemView.findViewById(R.id.colourView);
        }
    }
}
