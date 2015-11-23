package com.accessasoft.asd_helper;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

// Created by pboyko1 on 11/23/2015.

public class Timer_Setup extends Activity{

    String[] themes = {"Spaceship","Unicorn","Pirate ship", "Fairy"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_setup);

        NumberPicker npHours = (NumberPicker) findViewById(R.id.npHours);
        npHours.setMaxValue(100);
        npHours.setMinValue(0);
        npHours.setValue(0);
        npHours.setWrapSelectorWheel(false);

        NumberPicker npMinutes = (NumberPicker) findViewById(R.id.npMinutes);
        npMinutes.setMaxValue(59);
        npMinutes.setMinValue(0);
        npMinutes.setValue(0);
        npMinutes.setWrapSelectorWheel(false);

        NumberPicker npSeconds = (NumberPicker) findViewById(R.id.npSeconds);
        npSeconds.setMaxValue(59);
        npSeconds.setMinValue(0);
        npSeconds.setValue(0);
        npSeconds.setWrapSelectorWheel(false);

        Spinner spinner = (Spinner) findViewById(R.id.ddlTheme);
        ArrayAdapter<String> themeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, themes);
        themeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(themeAdapter);

        Button btnStartTimer = (Button) findViewById(R.id.btnStartTimer);
        btnStartTimer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_timer_setup);
                Toast.makeText(getApplicationContext(),"Timer Start Clicked", Toast.LENGTH_LONG).show();

            }
        });

    }
}
