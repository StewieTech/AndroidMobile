package com.example.SoccerLeagueApp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class SecondActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;

    String[] serialNumbers = {"1", "2", "3", "4", "5", "6", "7","8","9","10"};
    int[] imageIcons = {R.drawable.baseline_account_circle_24,R.drawable.baseline_account_circle_24,R.drawable.baseline_account_circle_24,R.drawable.baseline_account_circle_24,R.drawable.baseline_account_circle_24, R.drawable.baseline_account_circle_24,R.drawable.baseline_account_circle_24, R.drawable.baseline_account_circle_24, R.drawable.baseline_account_circle_24,R.drawable.baseline_account_circle_24       };

    String[] namePlayers = {"Lebron James", "Kobe Bryant", "Michael Jordan", "Christian Ronaldo", "Shaq Oneil", "Kevin Durant", "Steph Curry", "Dwight Howard", "JR Smith", "Demar Derozan"};
    String[] scorePlayers = {"10", "9", "10", "5","6","2","7","8","9","1"};

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        toolbar = findViewById(R.id.actToolbar);
        setSupportActionBar(toolbar);
        FunAdapter adapter = new FunAdapter( namePlayers,scorePlayers, this, serialNumbers, imageIcons );

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item)
//    {
//        if (item.getItemId() == R.id.itemProfile) {
//            Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show();
//        } else if (item.getItemId())
//    }

};


