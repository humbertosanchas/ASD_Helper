package com.accessasoft.asd_helper;

import android.location.Location;
import android.provider.SyncStateContract;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public  LatLng current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        MainActivity n = new MainActivity();
        n.getSavesList();

        // Add a marker in Sydney and move the camera
 //       mMap.setMyLocationEnabled(true);
 //       Location cLoc = mMap.getMyLocation();
//        LatLng current = new LatLng(cLoc.getLatitude(),cLoc.getLongitude());
        try
        {
            FileInputStream file = MapsActivity.this.openFileInput("incidentRecord");
            ObjectInputStream in = new ObjectInputStream(file);
            Object obj = in.readObject();

            while(obj != null)
            {
                IncidentToSave data = (IncidentToSave) obj;
                IncidentForMap m = new IncidentForMap(data.incidentRecord, data.lat, data.longa);
                current = new LatLng(m.getCurrentLatitude(),m.getCurrentLongitude());
                mMap.addMarker(new MarkerOptions()
                        .position(current)
                        .title(data.incidentRecord));
                obj = in.readObject();
            }
            in.close();
            file.close();
        }
        catch (Exception ex)
        {}
        //mMap.addMarker(new MarkerOptions().position(current).title("Current Location"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(current, 11));
    }
}
