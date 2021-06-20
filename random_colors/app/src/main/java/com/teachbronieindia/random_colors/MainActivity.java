package com.teachbronieindia.random_colors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b;
    Random rn;
    ConstraintLayout con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rn = new Random();
        con = findViewById(R.id.cons);

        b = findViewById(R.id.btn);
        b.setOnClickListener(v -> {
            con.setBackgroundColor(Color.rgb(rn.nextInt(256), rn.nextInt(256), rn.nextInt(256)));
        });
    }
}