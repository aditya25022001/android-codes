package com.example.externalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText fileName, fileData;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileName = (EditText)findViewById(R.id.etFileName);
        fileData = (EditText)findViewById(R.id.etFileData);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String file = fileName.getText().toString();
                String data = fileData.getText().toString();
                try {
                    File myFile = new File(file);
                    myFile.createNewFile();
                    FileOutputStream fout = new FileOutputStream(myFile);
                    OutputStreamWriter myWriter = new OutputStreamWriter(fout);
                    myWriter.append(data);
                    myWriter.close();
                    Toast.makeText(getApplicationContext(), "Data Saved"+getFilesDir(), Toast.LENGTH_LONG).show();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

    }
}