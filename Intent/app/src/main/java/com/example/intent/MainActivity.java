package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText name, branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button)findViewById(R.id.btnSubmit);
        name = (EditText)findViewById(R.id.etName);
        branch = (EditText)findViewById(R.id.etBranch);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = name.getText().toString();
                String uBranch = branch.getText().toString();

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("name",uName);
                intent.putExtra("branch",uBranch);

                startActivity(intent);
            }
        });
    }
}