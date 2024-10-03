package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    TextView errorTextView ;

//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("Assign1", "on Start method");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d("Assign1", "on Stop method");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("Assign1", "on Destroy method");
//    }
//
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d("Assign1", "on Pause method");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("Assign1", "on Resume method");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Assign2", "On Create method");


        EditText emailEdit = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordEdit = findViewById(R.id.editTextTextPassword);
        Button btnLogin = findViewById(R.id.buttonLogin);
        errorTextView = findViewById(R.id.viewError);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = emailEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                if(emailText.equals("admin@example.com") && password.equals("1234")) {
                    Toast.makeText(MainActivity.this, "You Logged in <3", Toast.LENGTH_SHORT).show();
                    errorTextView.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed </3 ", Toast.LENGTH_LONG).show();
                    errorTextView.setText("Invalid email or password");
                    errorTextView.setVisibility(View.VISIBLE);
                }


            }
        });





    }
}