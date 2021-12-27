package com.niajmahmud.helloworls.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.niajmahmud.helloworls.R;
import com.niajmahmud.helloworls.service.TimerService;

public class ServiceActivity extends AppCompatActivity {
    private TextView textView;
    public TimerService timerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_text1);

        Button buttonSign = findViewById(R.id.buttonStartService);
        textView = findViewById(R.id.textView44);

        ServiceConnection mServiceConnection = new ServiceConnection() {

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                TimerService.MyBinder binder = (TimerService.MyBinder) service;
                timerService = binder.getMyTimerService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TimerTask timerTask = new TimerTask(textView);
                Thread thread = new Thread(timerTask);
                thread.start();*/

                Intent intent = new Intent(ServiceActivity.this, TimerService.class);
                startService(intent);
                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

                if (timerService != null) {
                    textView.setText("" + timerService.getUpdate());
                }
            }
        });

    }

    /*class TimerTask implements Runnable{

        @Override
        public void run() {
            for (int i = 1; i <= 30; i++) {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                textView.setText("" + i);

            }
        }
    }*/
}

class TimerTask implements Runnable {

    private TextView t;

    TimerTask(TextView textView) {
        t = textView;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            t.setText("" + i);

        }
    }
}

