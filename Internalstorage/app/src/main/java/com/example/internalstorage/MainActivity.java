package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText fileName, data;
    Button btnSubmit, btnRead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileName = (EditText)findViewById(R.id.etFileName);
        data = (EditText)findViewById(R.id.etData);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnRead = (Button)findViewById(R.id.btnRead);
        
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String file = fileName.getText().toString();
                String fileData = data.getText().toString();
                FileOutputStream fout;
                try {
                    //whatever used belongs to program or only this application --> MODE_PRIVATE
                    fout = openFileOutput(file, Context.MODE_PRIVATE);
                    fout.write(fileData.getBytes());
                    fout.close();
                    Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_LONG).show();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String file = fileName.getText().toString();
                StringBuffer sb = new StringBuffer();
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(file)));
                    String readData;
                    while((readData=br.readLine())!=null){
                        sb.append(readData);
                    }
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),sb.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}