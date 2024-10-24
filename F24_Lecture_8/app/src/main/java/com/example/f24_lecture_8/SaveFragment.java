package com.example.f24_lecture_8;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveFragment extends Fragment {

    Button btnSave ;
    EditText txtData ;
    public SaveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save, container, false);
        btnSave = view.findViewById(R.id.btnSave) ;
        txtData = view.findViewById(R.id.txtData) ;

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = txtData.getText().toString() ;

                FileOutputStream fileOutputStream = null ;

                try {
                    fileOutputStream = getActivity().openFileOutput("seneca.txt", Context.MODE_APPEND);
                    fileOutputStream.write(text.getBytes());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        });
        return view ;
    }
}