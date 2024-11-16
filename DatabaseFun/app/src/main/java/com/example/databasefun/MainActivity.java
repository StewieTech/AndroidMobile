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
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton ;
    RecyclerView recyclerView ;
    List<Car> cars ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recyclerView) ;
    floatingActionButton = findViewById(R.id.floatingActionButton) ;

    AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "myDB").allowMainThreadQueries().build() ;

    cars = db.carDao().getAllCars() ;

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
    @Override
    protected void onResume() {
        super.onResume();
        cars = db.carDao().getAllCars() ;
        carAdapter.notifyDataSetChanged() ;
        }
}


