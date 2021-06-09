package com.teachBronieIndia.broadcast_receiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tv;
    ProgressBar pb;
    BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        pb = findViewById(R.id.progressBar);

        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                tv.setText(new StringBuilder().append("Battery level : ").append(level).toString());
                pb.setProgress(level);
                ConstraintLayout c = findViewById(R.id.cons);

                if (level > 60)
                    c.setBackgroundColor(Color.GREEN);
                else if (level > 30)
                    c.setBackgroundColor(Color.BLUE);
                else
                    c.setBackgroundColor(Color.RED);
            }
        };
    }


    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(br, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }
}