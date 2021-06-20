package com.teachbronieindia.music_player_with_foregroundjob;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;

public class MyService extends Service {
    public MyService() {}

    MediaPlayer music;

    @Override
    public void onCreate() {
        super.onCreate();
        music = MediaPlayer.create(this, R.raw.tera);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        music.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        music.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}