package com.example.myspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button button;
    private TextView resultView;
    private ProgressBar progressBar;
    private String stringBuilder;
    private int value;

    private String[] countryname;
    private int[] flags = {R.drawable.bangladesh, R.drawable.china, R.drawable.india, R.drawable.united_states, R.drawable.pakistan, R.drawable.united_arab_emirates};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner_id);
        button = findViewById(R.id.buttton_id);
        progressBar = findViewById(R.id.progress_id);
        resultView = findViewById(R.id.Resultview_id);
        countryname = getResources().getStringArray(R.array.country_name);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doprogress();
            }
        });

        thread.start();

        CustomAdepter adepter = new CustomAdepter(this, countryname, flags);
        spinner.setAdapter(adepter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, countryname[position] + " selected", Toast.LENGTH_SHORT).show();
                if (countryname[position] != null) {
                    stringBuilder = countryname[position];
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText(value + stringBuilder + " selcted");
            }
        });


    }

    private void doprogress() {

        for (value = 0; value < 100; value = value + 10) {

            try {
                Thread.sleep(1000);
                progressBar.setProgress(value + 10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (value == 100) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent();
                    startActivity(intent);
                }
            });

        }

    }


}