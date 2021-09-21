package com.example.textapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email, name, num1, num2;
    Button submit;
    String nameValue, emailValue;
    int num1var, num2var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.etName);
        email = (EditText)findViewById(R.id.etEmail);
        submit = (Button)findViewById(R.id.btnClick);
        num1 = (EditText)findViewById((R.id.etNum1));
        num2 = (EditText)findViewById((R.id.etNum2));

        nameValue = name.getText().toString();
        emailValue = email.getText().toString();
        num1var = Integer.parseInt(num1.getText().toString());
        num1var = Integer.parseInt(num2.getText().toString());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), ""+name.getText().toString()+" with email "+email.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), ""+Integer.parseInt(num1.getText().toString())+" + "+Integer.parseInt(num2.getText().toString())+" = "+(Integer.parseInt(num1.getText().toString())+Integer.parseInt(num2.getText().toString())), Toast.LENGTH_LONG).show();
            }
        });
    }
}