package com.example.exam_question_1_errol;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> nameCars = new ArrayList<>(Arrays.asList("Corolla", "Civic", "PathFinder", "7 Series", "A4", "Yukon", "Model 3", "Alto", "E Class", "Range Rover Sport", "Tuscon"));
        List<String> modelCars = new ArrayList<>(Arrays.asList("Toyota", "Honda", "Nissan", "BMW", "Audi", "GMC", "Tesla", "Suziki", "Mercedes", "Land Rover", "Hyundai"));

        recyclerView = findViewById(R.id.viewRecycle);
        PrimaryAdapter adapter = new PrimaryAdapter(this, nameCars, modelCars);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}