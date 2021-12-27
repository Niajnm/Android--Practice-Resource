package com.example.checkbox2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox javaCheckbox, cplusCheckbox,pythonCheckbox;
    private Button Showbutton;
    private TextView resultView;
    private SeekBar seekBar;
    private TextView seekbarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.Seek_ID);
        seekbarView = findViewById(R.id.Textview_seek);

    javaCheckbox = findViewById(R.id.java_id);
    cplusCheckbox= findViewById(R.id.cprogramming_id);
    pythonCheckbox = findViewById(R.id.python_id);
    Showbutton =findViewById(R.id.okbutton_id);
    resultView= findViewById(R.id.view_id);

     //seekbarView.setText("Volume :"+seekBar.getProgress());
     seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
         @Override
         public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
             seekbarView.setText(""+progress);
         }

         @Override
         public void onStartTrackingTouch(SeekBar seekBar) {

         }

         @Override
         public void onStopTrackingTouch(SeekBar seekBar) {

         }
     });

    Showbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            StringBuilder stringBuilder = new StringBuilder();

            if (javaCheckbox.isChecked()){
                 String value = javaCheckbox.getText().toString();
                 stringBuilder.append(value+" ");

            }
            if (cplusCheckbox.isChecked()){
                String value = cplusCheckbox.getText().toString();
                stringBuilder.append(value+" ");

            }
            if (pythonCheckbox.isChecked()){
                String value = pythonCheckbox.getText().toString();
                stringBuilder.append(value+" ");

            }
            resultView.setText(stringBuilder+"are selected");

        }
    });

    }
}