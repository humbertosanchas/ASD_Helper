package com.accessasoft.asd_helper;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class MainActivity extends Activity {

    public static ArrayList<IncidentToSave> _saves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton btnTimerSetup = (ImageButton) findViewById(R.id.btnTimer);
        btnTimerSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timerSetupPage = new Intent(v.getContext(), Timer_Setup.class);
                startActivityForResult(timerSetupPage, 0);
            }
        });

        ImageButton btnIncident = (ImageButton) findViewById(R.id.btnIncident);
        btnIncident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent incidentTrackingPage = new Intent(v.getContext(), IncidentTracker.class);
                startActivityForResult(incidentTrackingPage,0);
            }
        });

        ImageButton btnHistory = (ImageButton) findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyPage = new Intent(v.getContext(), History.class);
                startActivityForResult(historyPage,0);
            }
        });



    }

    public void setSavesList()
    {
        try {
            FileInputStream file = MainActivity.this.openFileInput("incidentRecord");
            ObjectInputStream in = new ObjectInputStream(file);
            Object obj = in.readObject();
            while (obj != null) {
                //IncidentToSave data = (IncidentToSave) obj;
                _saves.add((IncidentToSave) obj);
                obj = in.readObject();
            }
            in.close();
            file.close();
        } catch (Exception ex) {
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
