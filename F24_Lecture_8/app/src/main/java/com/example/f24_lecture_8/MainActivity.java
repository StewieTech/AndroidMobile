package com.example.f24_lecture_8;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView) ;
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null ;
                if (item.getItemId() == R.id.home) {
                    Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show() ;
                    fragment = new HomeFragment() ;
                }
                else if (item.getItemId() == R.id.save) {
                    Toast.makeText(MainActivity.this, "Save Selected", Toast.LENGTH_SHORT).show();
                    fragment = new SaveFragment() ;
                }

                else if (item.getItemId() == R.id.load){
                    Toast.makeText(MainActivity.this, "Load Selected", Toast.LENGTH_SHORT).show();
                    fragment = new LoadFragment() ;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainerView, fragment) ;
                transaction.commit() ;

                return true;
            }
        });

    }
}