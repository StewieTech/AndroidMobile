package com.example.fetchapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView schoolTxtView ;
    TextView websiteTxtView ;
    TextView stateTxtView ;

    private RecyclerView recyclerView;
    private FunAdapter funAdapter;
    private ArrayList<Uni> unis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Universities and Colleges in Canada");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        unis = new ArrayList<>();
        funAdapter = new FunAdapter(this, unis);
        recyclerView.setAdapter(funAdapter);


    fetchJSONArray() ;
    }

    private void fetchJSONArray() {
        Log.d("Seneca", "fetchJSONArray Called");
        String urlString = "http://universities.hipolabs.com/search?country=Canada";
        RequestQueue requestQueue  = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(urlString, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Seneca", "onResponse Called");
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                       /*
                        schoolTxtView.append(jsonObject.getString("name"));
                        websiteTxtView.append(jsonObject.getString("web_pages"));
                        stateTxtView.append(jsonObject.getString("state-province"));
*/
                        String schoolName = jsonObject.getString("name");
                        String schoolProvince = jsonObject.isNull("state-province") ? "NA" : jsonObject.getString("state-province");
                        JSONArray webPageArray = jsonObject.getJSONArray("web_pages") ;
                        String webPage = webPageArray.getString(0);

                        Log.d("Seneca",schoolName + schoolProvince);

                        Uni uni = new Uni(schoolName, schoolProvince, webPage);
                        unis.add(uni) ;

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                funAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Seneca","Error has been called");
                error.printStackTrace();

            }
        });

        Log.d("Seneca", "Add Json Request Called");
        requestQueue.add(jsonArrayRequest);
    }
}
