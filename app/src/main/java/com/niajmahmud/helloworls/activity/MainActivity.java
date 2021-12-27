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


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewHello);

        Button button = findViewById(R.id.buttonHello);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button5);
        Button button6 =findViewById(R.id.button6);
        Button button88 = findViewById(R.id.button88);
        Button button99 = findViewById(R.id.button99);
        Button buttonlogin = findViewById(R.id.buttonLogin);
        Button button999 = findViewById(R.id.button999);

        button88.setOnClickListener(this);
        button99.setOnClickListener(this);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("choose country name");

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailsActivity("bd");

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailsActivity("cn");

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailsActivity("usa");
            }


        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailsActivity("canada");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button6.setText("empty");
            }
        });
        button999.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
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
            textView.setText(msg);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button88){
            openDetailsActivity("nanjing");

        }
        if (v.getId()==R.id.button99){
            openDetailsActivity("south");

        }

    }

    private void openDetailsActivity(String value) {
        Intent intent = new Intent(MainActivity.this, ListActivity2.class);
        intent.putExtra("key_name", value);
        startActivity(intent);
    }
    public  void showMsg (View v){
        if (v.getId()==R.id.button999){
            Toast.makeText(MainActivity.this,"button is empty",Toast.LENGTH_LONG).show();
        } else if (v.getId()==R.id.button8888){
            Toast.makeText(MainActivity.this,"button is not using",Toast.LENGTH_LONG).show();
        }


    }
}
