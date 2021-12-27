package com.niajmahmud.helloworls.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.niajmahmud.helloworls.R;

public class DetailsActivity extends AppCompatActivity {
 TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Button button = findViewById(R.id.button);
        textView2 =findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("my-message");
                intent.putExtra("message", "Hi this is a test message");
                LocalBroadcastManager.getInstance(DetailsActivity.this).sendBroadcast(intent);
            }
        });
        IntentFilter intentFilter = new IntentFilter("my-message");
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(onReceiveMessage, intentFilter);

    }

    BroadcastReceiver onReceiveMessage = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("Test", "onReceive: " + intent.getExtras());
            String msg = intent.getExtras().getString("message");
            textView2.setText(msg);
            Toast.makeText(DetailsActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    };

}