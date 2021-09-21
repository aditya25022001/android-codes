package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox espresso,americana, chai, coffee;
    Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        espresso = (CheckBox)findViewById(R.id.espresso);
        americana = (CheckBox)findViewById(R.id.americana);
        chai = (CheckBox)findViewById(R.id.chai);
        coffee = (CheckBox)findViewById(R.id.coffee);
        order = (Button)findViewById(R.id.btnOrder);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalBill=0;
                StringBuilder result = new StringBuilder();
                result.append("Your order is ");
                if(espresso.isChecked()){
                    result.append("\n Espresso 150/-");
                    totalBill+=150;
                }
                if(americana.isChecked()){
                    result.append("\n Americana 150/-");
                    totalBill+=150;
                }
                if(chai.isChecked()){
                    result.append("\n Chai 20/-");
                    totalBill+=20;
                }
                if(coffee.isChecked()){
                    result.append("\n Coffee 50/-");
                    totalBill+=50;
                }
                result.append("\n Total : "+totalBill+"/-");
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}