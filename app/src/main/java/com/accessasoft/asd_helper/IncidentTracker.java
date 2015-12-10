package com.accessasoft.asd_helper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Paul Boyko on 11/25/2015.
 */
public class IncidentTracker extends Activity implements Serializable {

    Date startTime;
    Date endTime = null;
    LocationManager locManager = null;
    public double longitude;
    public double latitude;
    String incidentRecord;
    String precedentRecord;
    String resolutionRecord;
    String moodAfterRecord;
    String best;


    private SparseArray<String> providerStatus = new SparseArray<String>() {
        //initialize collection with status values using keys provided by the location provider
        {
            put(LocationProvider.AVAILABLE, "Available");
            put(LocationProvider.OUT_OF_SERVICE, "Out of Service");
            put(LocationProvider.TEMPORARILY_UNAVAILABLE, "Temporarily Unavailable");
            put(-1, "Not Reported");
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_tracker);

        locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        final LocationListener nLocListener = new NewLocationListener();

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        best = locManager.getBestProvider(criteria, true);

        Button btnStartIncident = (Button) findViewById(R.id.btnStart);
        btnStartIncident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startTime = new Date();
                try {
                    locManager.requestLocationUpdates(best, 0, 0f, nLocListener);
//
                    Toast.makeText(getApplicationContext(), "Start Clicked" + startTime.toString(), Toast.LENGTH_LONG).show();
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
            }

        });

        Button btnStopIncident = (Button) findViewById(R.id.btnStop);
        btnStopIncident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endTime = new Date();
                Toast.makeText(getApplicationContext(), "Stop Clicked " + endTime.toString(), Toast.LENGTH_LONG).show();
            }
        });

//        CheckBox chkIncident = (CheckBox) findViewById(R.id.chkIncident);
//        CheckBox chkPrecident = (CheckBox) findViewById(R.id.chkPrecident);
//        CheckBox chkResolution = (CheckBox) findViewById(R.id.chkResolution);
//        CheckBox chkMoodAfter = (CheckBox) findViewById(R.id.chkMoodAfter);

        Button btnSaveIncident = (Button) findViewById(R.id.btnSave);
        btnSaveIncident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtIncident = (EditText) findViewById(R.id.txtIncident);
                EditText txtPrecedent = (EditText) findViewById(R.id.txtPrecident);
                EditText txtResolution = (EditText) findViewById(R.id.txtResolution);
                EditText txtMoodAfter = (EditText) findViewById(R.id.txtMoodAfter);

                if (endTime != null) {
                    if (txtIncident.getText().toString().length() > 0) {
                        incidentRecord = txtIncident.getText().toString();
                        if (txtPrecedent.getText().toString().length() > 0) {
                            precedentRecord = txtPrecedent.getText().toString();
                            if (txtResolution.getText().toString().length() > 0) {
                                resolutionRecord = txtResolution.getText().toString();
                                if (txtMoodAfter.getText().toString().length() > 0) {
                                    moodAfterRecord = txtMoodAfter.getText().toString();
                                    FileOutputStream fos;
                                    ObjectOutputStream os;
                                    try {
                                        fos = IncidentTracker.this.openFileOutput("incidentRecord", Context.MODE_PRIVATE);
                                        os = new ObjectOutputStream(fos);
                                        os.writeObject(new IncidentToSave(startTime, endTime, incidentRecord, precedentRecord, resolutionRecord, moodAfterRecord, latitude,longitude));
                                        os.close();
                                        fos.close();
                                        Toast.makeText(getApplicationContext(), "Record Saved", Toast.LENGTH_LONG).show();

                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Incident can not be left blank", Toast.LENGTH_LONG).show();
                                    txtMoodAfter.requestFocus();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Resolution can not be left blank", Toast.LENGTH_LONG).show();
                                txtResolution.requestFocus();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Precient can not be left blank", Toast.LENGTH_LONG).show();
                            txtPrecedent.requestFocus();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Incident can not be left blank", Toast.LENGTH_LONG).show();
                        txtIncident.requestFocus();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Event must be stopped before it can be saved", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public class NewLocationListener implements LocationListener {

        public void onLocationChanged(Location loc) {
            longitude = loc.getLongitude();
            latitude = loc.getLatitude();
            try
            {
                locManager.removeUpdates(this);
            }
            catch (SecurityException e)
            {
            }
        }
        public void onProviderDisabled(String arg0) {

        }
        public void onProviderEnabled(String provider) {

        }
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
    }
}