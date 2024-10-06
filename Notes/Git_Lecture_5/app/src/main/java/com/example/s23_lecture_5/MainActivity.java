package com.example.s23_lecture_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] cars = getResources().getStringArray(R.array.cars);

        CarAdapter carAdapter = new CarAdapter(this, cars);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(carAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}