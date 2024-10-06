package com.example.s23_lecture_5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {

    Context context;
    String[] cars;

    CarAdapter(Context context, String[] cars)
    {
        this.context = context;
        this.cars = cars;
    }

    @NonNull
    @Override
    public CarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.MyViewHolder holder, int position) {
        holder.txtCar.setText(cars[position]);
    }

    @Override
    public int getItemCount() {
        return cars.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtCar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCar = itemView.findViewById(R.id.txtCar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();
                    customDialog();
                }
            });
        }

        void showDialog()
        {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setTitle("Purchase");
            alertDialog.setMessage("Do you want to buy this car?");
            alertDialog.setIcon(R.drawable.baseline_warning_24);
            alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(context, "Congratulations, you bought the car.", Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialog.create().show();

        }

        void customDialog()
        {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null);
            alertDialog.setView(view);

            Button btnLogin = view.findViewById(R.id.btnLogin);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "You logged in successfully", Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.create().show();
        }
    }
}
