package com.example.assignment1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Assign1", "on Start method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Assign1", "on Stop method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Assign1", "on Destroy method");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Assign1", "on Pause method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Assign1", "on Resume method");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Assign1", "On Create method");

//        TextView txtView = findViewById(R.id.textView);
//        Button button = findViewById(R.id.btnClick);




    }
}