package com.niajmahmud.helloworls.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;


public class TimerService extends Service {
    public IBinder mBinder = new MyBinder();
    TimerTask timerTask;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        timerTask = new TimerTask();
        Thread thread = new Thread(timerTask);
        thread.start();
    }

    public int getUpdate() {
        return timerTask.getValue();
    }

    public class MyBinder extends Binder {
        public TimerService getMyTimerService() {
            return TimerService.this;
        }
    }

}

class TimerTask implements Runnable {
    final static String TAG = "TimerService";
    int value = 0;

    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            try {
                Thread.sleep(1000);
                Log.d(TAG, "run: " + i);
                value = i;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public int getValue() {
        return value;
    }
}
