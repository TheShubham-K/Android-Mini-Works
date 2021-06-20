package com.teachbronieindia.dynamic_random_colors;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView imgView1, imgView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView1 = findViewById(R.id.img_view1);
        imgView2 = findViewById(R.id.img_view2);

        Timer timer = new Timer();
        MyTimer myTimer = new MyTimer();
        timer.schedule(myTimer, 1000, 1000);
    }

    private class MyTimer extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Random ran = new Random();
                    imgView1.setBackgroundColor(Color.rgb(ran.nextInt(256), ran.nextInt(256),ran.nextInt(256)));
                    imgView2.setBackgroundColor(Color.argb(255, ran.nextInt(256), ran.nextInt(256),ran.nextInt(256)));
                }
            });
        }
    }
}