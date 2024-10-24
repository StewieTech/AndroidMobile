package com.example.f24_lecture_8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoadFragment extends Fragment {

    Button btnLoad  ;
    TextView txtShowData ;
    public LoadFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_load, container, false);
        btnLoad = view.findViewById(R.id.btnShow) ;
        txtShowData = view.findViewById(R.id.txtShowData ) ;

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fileInputStream = null;

                try {
                    fileInputStream = getActivity().openFileInput("seneca.txt");
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    StringBuilder builder = new StringBuilder() ;

                    String text ;

                    while ((text = reader.readLine()) != null) {
                        builder.append(text);
                    }
                    txtShowData.setText(builder.toString());

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
        return view ;
    }
}