package com.example.f24_lecture_5;

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

    // everything related to recycleView is done in the Adaptor view
    Context context;
    String cars[] ;

    CarAdapter(Context context, String[] cars) {
        this.context = context ;
        this.cars = cars ;
    }

    @NonNull
    @Override
    // new rows are expensive so RecyclerView will reuse those rows and just update them with data
    public CarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, null);
        return new MyViewHolder(view) ;
    }

    // data binding is done here binding data to each row
    @Override
    public void onBindViewHolder(@NonNull CarAdapter.MyViewHolder holder, int position) {
        holder.txtName.setText(cars[position]);

    }

    @Override
    public int getItemCount() {
        return cars.length ;
    }

    //
    // gives libery of accessing all of the controls to find there references
    // this is the class working with the UI
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // anytime we see findViewById can I assume that it's working with UI ?
            txtName = itemView.findViewById(R.id.txtName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int index = getAdapterPosition();
            Toast.makeText(context ,cars[index] + "Clicked",  Toast.LENGTH_SHORT).show();
            showAlert();
        }
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Information");
        builder.setIcon(R.drawable.baseline_notifications_active_24);
        builder.setMessage("Do you want to buy this car?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(context, "Congratulations on Buying this carr!!", Toast.LENGTH_LONG);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(context, "You Failed to buy !!!", Toast.LENGTH_SHORT);
            }
        });

        builder.show();
    }

    private void showCustomAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.login_layout, null);
        builder.setView(view);

        AlertDialog dialog = builder.create();
        Button btnLogin = view.findViewById(R.id.btnLogin);
        Button btnCancel = view.findViewById(R.id.btnCancel);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Login Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
