package com.example.networking;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btnDownload;
    ImageView imageView;
    Button btnFetch;
    RecyclerView recyclerView ;
    ArrayList<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = findViewById(R.id.downloadImage);
        imageView = findViewById(R.id.imageView);

        recyclerView = findViewById(R.id.recyclerView);

        User[] userList = new User[] {
                new User(1, "Steve", "steve@jobs.ca");
                new User(2, "Bill", "bill@gates.ca");
        };


        users = new ArrayList<>();

        UserAdapter userAdapter = new UserAdapter(this, users);

        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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

        btnFetch = findViewById(R.id.btnFetch);
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchJSON();
            }
        });


    }

    private void fetchJSON() {
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        String url2 = "https://jsonplaceholder.typicode.com/users";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        User user = new User(jsonObject.getInt("id"), jsonObject.getString("name"),jsonObject.getString("email"));
                        users.add(user);
                        Log.d("Seneca", user.toString());
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("Seneca", response.getString("title"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.getStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
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