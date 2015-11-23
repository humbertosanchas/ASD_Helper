package com.accessasoft.asd_helper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;


// Created by pboyko1 on 11/23/2015.

public class Timer_Setup  extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker npHours = (NumberPicker) findViewById(R.id.npHours);
        npHours.setMaxValue(100);
        npHours.setMinValue(0);
        npHours.setValue(0);
        npHours.setWrapSelectorWheel(false);

        NumberPicker npMinutes = (NumberPicker) findViewById(R.id.npMinutes);
        npMinutes.setMaxValue(60);
        npMinutes.setMinValue(0);
        npMinutes.setValue(0);
        npMinutes.setWrapSelectorWheel(false);

        NumberPicker npSeconds = (NumberPicker) findViewById(R.id.npSeconds);
        npSeconds.setMaxValue(60);
        npSeconds.setMinValue(0);
        npSeconds.setValue(0);
        npSeconds.setWrapSelectorWheel(false);

        Button btnStartTimer = (Button) findViewById(R.id.btnStartTimer);
        btnStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_timer_setup);
                Toast.makeText(getApplicationContext(),"Timer Start Clicked", Toast.LENGTH_LONG);
            }
        });

    }
}
