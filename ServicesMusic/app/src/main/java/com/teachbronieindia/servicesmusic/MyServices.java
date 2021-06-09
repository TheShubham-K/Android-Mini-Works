package com.teachbronieindia.servicesmusic;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MyServices extends Service {

    public MyServices(){}

    MediaPlayer music;

    @Override
    public void onCreate() {
        super.onCreate();
        music = MediaPlayer.create(this, R.raw.tera);
//        music.setLooping(false);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service  Started", Toast.LENGTH_SHORT).show();
        music.start();
        return startId;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service  Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
        music.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException( "Not yet implemented" );
    }

}
