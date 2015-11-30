package com.accessasoft.asd_helper;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;

import java.util.Date;

/**
 * Created by Paul Boyko on 11/25/2015.
 */
public class IncidentTracker extends Activity implements LocationListener {

    Date startTime;
    Date endTime;
    LocationManager locManager = null;
    Location eventLocation = null;
    Location startLocation = null;
    Location endLocation = null;
    String incidentRecord;
    String precidentRecord;
    String resolutionRecord;
    String moodAfterRecord;

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

        Button btnStartIncident = (Button) findViewById(R.id.btnStart);
        btnStartIncident.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(Criteria.ACCURACY_FINE);
                criteria.setPowerRequirement(Criteria.POWER_LOW);

                String best = locManager.getBestProvider(criteria, true);
                locManager.requestLocationUpdates(best, 10001, 0f, IncidentTracker.this);

                startLocation = eventLocation;
                startTime = new Date();
            }
        });

    }

    @Override
    public void onLocationChanged(Location location)
    {
        if(this.eventLocation != null)
        {
            float distance = location.distanceTo(this.eventLocation);
        }
        this.eventLocation = location;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {

    }

    @Override
    public void onProviderEnabled(String provider)
    {

    }

    @Override
    public void onProviderDisabled(String provider)
    {

    }

}