package com.teachbronieindia.music_player_with_foregroundjob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3;
    private static boolean run = true;
    Timer timer = new Timer();
    MyTimer myTimer = new MyTimer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);



        b1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.schedule(myTimer, 1000, 1000);
                startService( new Intent(getApplicationContext(),MyService.class));
            }
        } );
        b2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                run = false;
                stopService( new Intent( getApplicationContext(),MyService.class ) );

            }
        } );
//
//        b3.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ConstraintLayout r= findViewById(R.id.cons);
//                Random g=new Random(  );
//                r.setBackgroundColor( Color.rgb( g.nextInt(),g.nextInt(),g.nextInt() ) );
//            }
//        } );

    }

    private class MyTimer extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(run){
                        ConstraintLayout r= findViewById( R.id.cons );
                        Random g=new Random();
                        r.setBackgroundColor(Color.rgb( g.nextInt(),g.nextInt(),g.nextInt()));
                    }else{
                        timer.cancel();
                        timer.purge();
                    }
                }
            });
        }
    }

}