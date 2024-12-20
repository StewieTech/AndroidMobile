package com.example.databasefun;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class AddCarActivity extends AppCompatActivity {

    EditText edtMake, edtName ;
    Button btnSave ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        btnSave = findViewById(R.id.btnSave );
        edtMake = findViewById(R.id.edtMake) ;
        edtName = findViewById(R.id.edtName) ;

        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "myDB").allowMainThreadQueries().build() ;

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.carDao().insertAll(new Car(edtMake.getText().toString(), edtName.getText().toString()));
                Toast.makeText(AddCarActivity.this, "Car added to the database", Toast.LENGTH_LONG) ;
                finish();
            }
        });
    }
}