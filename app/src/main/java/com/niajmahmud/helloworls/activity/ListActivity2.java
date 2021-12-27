package com.niajmahmud.helloworls.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.niajmahmud.helloworls.R;

public class ListActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle("List");
        TextView textViewDetails = findViewById(R.id.textViewDetials);
        String key = getIntent().getExtras().getString("key_name");

        if (key.equals("bd")) {
            textViewDetails.setText(R.string.bangladesh_details);
        } else if (key.equals("cn")) {
            textViewDetails.setText(R.string.china_details);
        } else if (key.equals("usa")) {
            textViewDetails.setText(R.string.usa_details);
        }else if (key.equals("canada")){
            textViewDetails.setText("canada_details");

        }else if (key.equals("nanjing")){
            textViewDetails.setText("adgqegfqy7f");
        }else if (key.equals("south")){
            textViewDetails.setText("000000000000000");
        }

    }
}