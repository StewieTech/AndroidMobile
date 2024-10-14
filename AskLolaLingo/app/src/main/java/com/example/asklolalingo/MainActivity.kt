package com.example.asklolalingo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent ;

class MainActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button ;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener {
            val intent = Intent(this, AskLolaChat::class.java);
            startActivity(intent);
        }




        }



    }