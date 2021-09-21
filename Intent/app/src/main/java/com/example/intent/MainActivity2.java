package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView name, branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = (TextView)findViewById(R.id.tvName);
        branch = (TextView)findViewById(R.id.tvBranch);

        String uName = getIntent().getStringExtra("name");
        String uBranch = getIntent().getStringExtra("branch");

        name.setText(uName);
        branch.setText(uBranch);
    }
}