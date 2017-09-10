package com.nilin.myapplication2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class PlayService extends Service {

    public MediaPlayer mp;

    public PlayService() {

    }

    class PlayBinder extends Binder {
        public PlayService getPlayService() {
            return PlayService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new PlayBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = new MediaPlayer();
        mp = MediaPlayer.create(this, R.raw.music);
    }

    public void start() {
            mp.start();
    }

}
