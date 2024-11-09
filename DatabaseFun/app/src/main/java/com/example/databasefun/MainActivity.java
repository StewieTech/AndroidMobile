package com.example.databasefun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton ;
    RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recyclerView) ;
    floatingActionButton = findViewById(R.id.floatingActionButton) ;

    String[] cars = {"Toyota", "Honda", "Suzuki", "Nissan", "Tesla", "Ford"} ;

    CarAdapter carAdapter = new CarAdapter(MainActivity.this, cars);

    recyclerView.setAdapter(carAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    floatingActionButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, AddCarActivity.class) ;
            startActivity(intent);
        }
    });



    }
}