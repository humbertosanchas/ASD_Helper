package com.accessasoft.asd_helper;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

// Created by pboyko1 on 11/23/2015.

public class Timer_Setup extends Activity implements AdapterView.OnItemSelectedListener{

    Spinner themeSpinner;
    String soundValue;
    String sleepValue;


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

      RadioGroup radSound = (RadioGroup) findViewById(R.id.radGroupSound);
      final RadioButton radSoundOn = (RadioButton)findViewById(R.id.radOn);
 //     final RadioButton radSoundOff = (RadioButton)findViewById(R.id.radOff);
      radSoundOn.setChecked(true);
      RadioButton radSoundValue = (RadioButton) findViewById(radSound.getCheckedRadioButtonId());
      soundValue = radSoundValue.getText().toString();

      radSound.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup group, int checkedId) {

              Toast.makeText(getBaseContext(),"Radio button selected " + soundValue, Toast.LENGTH_LONG).show();
          }
      });

        RadioGroup radAllowSleep = (RadioGroup) findViewById(R.id.radGroupSleep);
 //       final RadioButton radAllowSleepYes = (RadioButton) findViewById(R.id.radYes);
        final RadioButton radAllowSleepNo = (RadioButton) findViewById(R.id.radNo);
        radAllowSleepNo.setChecked(true);
        RadioButton radSleepValue = (RadioButton) findViewById(radAllowSleep.getCheckedRadioButtonId());
        sleepValue = radSleepValue.getText().toString();

        radAllowSleep.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Toast.makeText(getBaseContext(),"Radio button selected " + sleepValue, Toast.LENGTH_LONG).show();
            }
        });

       themeSpinner = (Spinner) findViewById(R.id.ddlTheme);
       ArrayAdapter themeAdapter = ArrayAdapter.createFromResource(this, R.array.themeSpinner, android.R.layout.simple_spinner_item);
        themeSpinner.setAdapter(themeAdapter);
        themeSpinner.setOnItemSelectedListener(this);

        Button btnStartTimer = (Button) findViewById(R.id.btnStartTimer);
        btnStartTimer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_timer_setup);
                Toast.makeText(getApplicationContext(),"Timer Start Clicked", Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        TextView themeSelected = (TextView) view;
        Toast.makeText(this,"Type Selected " + themeSelected.getText(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
