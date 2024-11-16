package com.example.networking;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    Button btnDownload;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = findViewById(R.id.downloadImage);
        imageView = findViewById(R.id.imageView);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                Bitmap bitmap = downloadImage("https://png.pngtree.com/png-vector/20240309/ourmid/pngtree-developers-are-coding-programs-on-computers-programmers-are-analyzing-data-png-image_11902650.png");
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                imageView.setImageBitmap(bitmap);
                    }
                });
                    }
                }).start();
            }
        });
    }

    private InputStream openConnection(String urlString) {
        InputStream inputStream = null ;

        try {
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection ;
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                inputStream = httpURLConnection.getInputStream();
            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return inputStream ;
    }

    private Bitmap downloadImage(String urlString) {
        InputStream inputStream = null ;
        Bitmap bitmap = null;

        inputStream = openConnection(urlString);

        BitmapFactory.decodeStream(inputStream);

        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bitmap;

    }
}