package com.teachbronie.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    EditText ed1, ed2;
    Button add, sub, prod, div, clear;
    ConstraintLayout cons1;
    int num1, num2;
    String s1, s2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getNumbers()){
                    num1 =
                    int sum = num1+num2;
                    t1.setText(Integer.toString(sum));
                    t1.setTextColor(Color.parseColor("B"));
                }
            }
        });


    }

    public boolean getNumbers(){

        ed1 = findViewById(R.id.edt1);
        ed2 = findViewById(R.id.edt2);
        t1 = findViewById(R.id.result);
        s1 = ed1.getText().toString();
        s2 = ed2.getText().toString();

        if(s1.equals("") && s2.equals("")){
            Toast.makeText(getApplicationContext(), "Please enter a Valid String", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            num1 = Integer.parseInt(s1);
            num2 = Integer.parseInt(s2);
        }
        return true;
    }

}