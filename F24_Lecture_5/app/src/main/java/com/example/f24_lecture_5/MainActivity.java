package com.example.f24_lecture_5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] cars  = {"Toyota", "Honda", "Suzuki", "Hyundai", "Ford","BMW","Mercedes","Audi","Tesla","Nissan","Mitsubishi"};

        recyclerView = findViewById(R.id.recyclerView);

        CarAdapter carAdapter = new CarAdapter(this, cars);

        recyclerView.setAdapter(carAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}