package com.nilin.myapplication2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by nilin on 2017/2/22.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected PlayService playService;
    private boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            PlayService.PlayBinder playBinder = (PlayService.PlayBinder) service;
            playService = playBinder.getPlayService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            playService = null;
            isBound = false;
        }
    };

    //绑定服务
    public void bindPlayService() {
        if (!isBound) {
            Intent intent = new Intent(this, PlayService.class);
            bindService(intent, conn, Context.BIND_AUTO_CREATE);
            isBound = true;
        }
    }

    //解除服务
    public void unbindPlayService() {
        if (isBound) {
            unbindService(conn);
            isBound = false;
        }
    }
}

