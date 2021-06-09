package com.teachbronieindia.servicesmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button p, s, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        p = findViewById(R.id.play);
        s = findViewById(R.id.stop);
        c = findViewById(R.id.color);

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MyServices.class));
            }
        });


        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MyServices.class));
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConstraintLayout cL = findViewById(R.id.cons);
                Random gen = new Random();
                cL.setBackgroundColor(Color.rgb(gen.nextInt(), gen.nextInt(), gen.nextInt()));

            }
        });

    }
}