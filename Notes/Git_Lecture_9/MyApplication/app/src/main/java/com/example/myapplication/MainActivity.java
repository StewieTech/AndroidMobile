package com.example.myapplication;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText txtData;
    Switch aSwitch;
    RadioGroup rdoGroup;
    RadioButton rdoTea, rdoCoffee;
    SharedPreferences preferences;
    ProgressBar progressBar;
    int progress = 0;
    Handler handler = new Handler();
    TextView txtProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        txtData = findViewById(R.id.txtData);
        aSwitch = findViewById(R.id.switch1);
        rdoGroup = findViewById(R.id.rdoGroup);
        rdoTea = findViewById(R.id.rdoTea);
        rdoCoffee = findViewById(R.id.rdoCoffee);
        progressBar = findViewById(R.id.progressBar);
        txtProgress = findViewById(R.id.txtProgress);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        loadData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < 100)
                {
                    progress++;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);
                            txtProgress.setText(progress + "%");
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();



    }

    private void saveData()
    {
        String text = txtData.getText().toString();
        boolean switchState = aSwitch.isChecked();
        int rdoState = 0;

        int check = rdoGroup.getCheckedRadioButtonId();

        if (check == R.id.rdoTea)
        {
            rdoState = 1;
        }
        else if (check == R.id.rdoCoffee)
        {
            rdoState = 2;
        }


        preferences = getSharedPreferences("My_Pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("myData", text);
        editor.putBoolean("switchState", switchState);
        editor.putInt("drink", rdoState);

        editor.apply();
    }

    private void loadData()
    {
        preferences = getSharedPreferences("My_Pref", MODE_PRIVATE);
        String text = preferences.getString("myData", "");
        boolean switchState = preferences.getBoolean("switchState", false);
        txtData.setText(text);
        aSwitch.setChecked(switchState);
        int rdoState = preferences.getInt("drink", 0);

        if (rdoState == 1)
        {
            rdoTea.setChecked(true);
        }
        else if (rdoState == 2)
        {
            rdoCoffee.setChecked(true);
        }
    }
}